package com.src.kick.helper;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.src.kick.domain.RestRequest;

import reactor.core.publisher.Mono;



@Component
public class RestHandler { 

    private final RestTemplate restTemplate;
    public RestHandler(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
	}
    
	public <T> Mono<T> execute(RestRequest request,ParameterizedTypeReference<T> reference) {
		try {
			return Mono.just(restTemplate.exchange(request.getUrl(), request.getMethod(), null,reference, request.getPathParams()).getBody());	
		}
		catch(Exception e) {
			throw new RuntimeException("Hmm Something wrong");
		}
		
	}
}
