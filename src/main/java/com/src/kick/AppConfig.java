package com.src.kick;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.event.LoggingEventListener;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import lombok.RequiredArgsConstructor;

@EnableReactiveMongoRepositories
@AutoConfigureAfter(EmbeddedMongoAutoConfiguration.class)
@RequiredArgsConstructor
public class AppConfig extends AbstractReactiveMongoConfiguration {

  

  @Override
  protected String getDatabaseName() {
    return "kick-it";
  }
  
  @Bean
	public LoggingEventListener mongoEventListener() {
		return new LoggingEventListener();
	}


@Override
public MongoClient reactiveMongoClient() {
	// TODO Auto-generated method stub
	return MongoClients.create(String.format("mongodb://localhost:%d", 27017));
}

//@Override
//public MongoClient reactiveMongoClient() {	
//	 return MongoClients.create(String.format("mongodb://localhost:%d", 27017));
//}
}
