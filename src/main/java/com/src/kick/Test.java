package com.src.kick;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.src.kick.domain.Competition;



public class Test {
    final ExecutorService executor = Executors.newFixedThreadPool( 2 );


	public static void main(String[] args) {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://api.football-data.org/v1/competitions/{competitionId}";
    	Map<String,Integer> pathParamsMap=new HashMap<>();
    	pathParamsMap.put("competitionId", 424);    	
//    	Observable<Competition> competition=Observable.from(CompletableFuture.supplyAsync(()-> {
//    		return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Competition>() {
//    		}, pathParamsMap).getBody();
//    	}));
//    	competition.subscribe(comp->{
//    		Observable.from(CompletableFuture.supplyAsync(()-> {
//        		return restTemplate.exchange("http://api.football-data.org/v1/competitions/{competitionId}/teams", HttpMethod.GET, null, new ParameterizedTypeReference<Competition>() {
//        		}, pathParamsMap).getBody();
//    	}));
//    		
//    		Observable.from(CompletableFuture.supplyAsync(()-> {
//        		return restTemplate.exchange("http://api.football-data.org/v1/competitions/{competitionId}/fixtures", HttpMethod.GET, null, new ParameterizedTypeReference<Competition>() {
//        		}, pathParamsMap).getBody();
//    	}));
    		
    	
}
}