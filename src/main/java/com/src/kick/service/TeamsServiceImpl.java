package com.src.kick.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.src.kick.domain.Player;
import com.src.kick.domain.PlayersResponse;
import com.src.kick.domain.Team;

import reactor.core.publisher.Mono;


@Service
public class TeamsServiceImpl implements TeamsService {
	private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(TeamsServiceImpl.class);

	public TeamsServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		restTemplate=restTemplateBuilder.build();
	}
	
	@Override
	public List<Team> topTeams() {
		
		return null;
	}
	
	@Override
	public Mono<Team> getTeam(Integer teamId) {
		logger.info("getTeam()");
    	String url="http://api.football-data.org/v1/teams/{teamId}";
    	Map<String,Integer> pathParamsMap=new HashMap<>();
    	pathParamsMap.put("teamId", teamId);
    	return Mono.just(restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Team>() {
		},pathParamsMap).getBody());
	}

	@Override
	public Mono<PlayersResponse> getPlayers(Integer teamId) {
		logger.info("getPlayers()");
    	String url="http://api.football-data.org/v1/teams/{teamId}/players";
    	Map<String,Integer> pathParamsMap=new HashMap<>();
    	pathParamsMap.put("teamId", teamId);
    	return Mono.just(restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<PlayersResponse>() {
		},pathParamsMap).getBody());
	}

}
