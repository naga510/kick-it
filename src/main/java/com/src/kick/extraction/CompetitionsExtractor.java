package com.src.kick.extraction;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.bson.Document;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.mongodb.core.convert.DbRefProxyHandler;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DbRefResolverCallback;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;

import com.mongodb.DBRef;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.src.kick.domain.Competition;
import com.src.kick.helper.RestHandler;
import com.src.kick.service.CompetitionService;

import reactor.core.publisher.Flux;





public class CompetitionsExtractor {
	
	static class NoOpDbRefResolver implements DbRefResolver {

		@Override
		public Optional<Object> resolveDbRef(MongoPersistentProperty property, DBRef dbref, DbRefResolverCallback callback,
				DbRefProxyHandler proxyHandler) {
			return Optional.empty();
		}

		@Override
		public DBRef createDbRef(org.springframework.data.mongodb.core.mapping.DBRef annotation,
				MongoPersistentEntity<?> entity, Object id) {
			return null;
		}

		@Override
		public Document fetch(DBRef dbRef) {
			return null;
		}

		@Override
		public List<Document> bulkFetch(List<DBRef> dbRefs) {
			return null;
		}
	}
	public static final DbRefResolver NO_OP_REF_RESOLVER = new NoOpDbRefResolver();

	public static void main(String[] args) {
		MappingMongoConverter converter = new MappingMongoConverter(NO_OP_REF_RESOLVER, new MongoMappingContext());
		converter.afterPropertiesSet();
		RestTemplateBuilder builder=new RestTemplateBuilder();
		RestHandler handler=new RestHandler(builder);
		CompetitionService  impl=new CompetitionService(builder,handler);
		MongoClient mongo = new MongoClient("localhost", 27017);
				MongoDatabase db= mongo.getDatabase("kick-it");
				MongoCollection<Document> docs= db.getCollection("competition");
		       //  Document doc=new Document();
		Flux<Competition> competitions= impl.getCompetitions();
		competitions.subscribe(new Consumer<Competition>() {

			@Override
			public void accept(Competition t) {
				System.out.println("Competition:");
				// TODO Auto-generated method stub
				Document doc=new Document();
				converter.write(t, doc);				
				docs.insertOne(doc);
			}
		});
		
		
		
		System.out.println("here");
	}
}
