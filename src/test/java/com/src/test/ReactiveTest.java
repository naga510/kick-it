package com.src.test;

import java.util.concurrent.CountDownLatch;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.src.kick.dao.CompetitionsRepository;
import com.src.kick.data.Competition;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactiveTest {

	@Autowired
	CompetitionsRepository repository;
	@Autowired
	ReactiveMongoOperations operations;
	
	@Before
	public void setUp() {

//		operations.collectionExists(Competition.class) 
//				.flatMap(exists -> exists ? operations.dropCollection(Competition.class) : Mono.just(exists)) //
//				.flatMap(o -> operations.createCollection(Person.class,
//						CollectionOptions.empty().size(1024 * 1024).maxDocuments(100).capped())) //
//				.then() //
//				.block();
//		
		Boolean exists =operations.collectionExists(Competition.class).block();
		System.out.println(exists);
		
	}
	
	@Test
	public void testkickItMongo() throws InterruptedException
	{
		CountDownLatch countDownLatch = new CountDownLatch(1);

		repository.findAll() //
				.doOnNext(System.out::println) //
				.doOnComplete(countDownLatch::countDown) //
				.doOnError(throwable -> countDownLatch.countDown()) //
				.subscribe();

		countDownLatch.await();
	}
	
	
}
