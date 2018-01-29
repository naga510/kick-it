package com.src.kick;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.spring.cache.CacheBuilder;
import com.couchbase.client.spring.cache.CouchbaseCacheManager;

@EnableCaching
@Configuration
public class CacheConfig {

	 public static final String CACHE_NAME = "competitions";
	 @Bean(destroyMethod = "disconnect")
	    public Cluster cluster() {
	        // connect to the couchbase-server running on your local machine
	        return CouchbaseCluster.create();
	    }

	    @Bean(destroyMethod = "close")
	    public Bucket bucket() {
	        // connect to the bucket named 'default' (which must exist on your Couchbase server)
	        // every cache related element will use this bucket
	        return cluster().openBucket("default");
	    }

	    @Bean
	    public CacheManager cacheManager() {
	        CacheBuilder cacheBuilder = CacheBuilder.newInstance(bucket()).withExpiration(0);
	        return new CouchbaseCacheManager(cacheBuilder, CACHE_NAME);
	    }
}
