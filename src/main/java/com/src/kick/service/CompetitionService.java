package com.src.kick.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.src.kick.CacheConfig;
import com.src.kick.dao.CompetitionsRepository;
import com.src.kick.domain.Competition;
import com.src.kick.domain.Fixture;
import com.src.kick.domain.FixtureResponse;
import com.src.kick.domain.LeagueTable;
import com.src.kick.domain.RestRequest;
import com.src.kick.domain.Team;
import com.src.kick.domain.TeamsResponse;
import com.src.kick.helper.RestHandler;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CompetitionService {
	@Autowired
	CompetitionsRepository competitionsRepository;
	
    private final RestTemplate restTemplate;
    private final RestHandler restHandler;
    private static final Logger logger = LoggerFactory.getLogger(CompetitionService.class);
    
    public CompetitionService(RestTemplateBuilder restTemplateBuilder,RestHandler handler) {
        this.restTemplate = restTemplateBuilder.build();
        this.restHandler=handler;
	}
    
    //@Cacheable(cacheNames=CacheConfig.CACHE_NAME)
    public Flux<Competition> getCompetitions() {
    	logger.info("getCompetitions()");
    	String url="http://api.football-data.org/v1/competitions";
    //logger.info("Competitions"+competitionsRepository.findAll().collectList().block());
     //competitionsRepository.findAll().doOnNext(System.out::println);
    	
    	return Flux.fromStream(restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Competition>>() {
		}).getBody().stream());
    }
    
    public Mono<Competition> getDetailedCompetition(Integer competitionId) {
    	logger.info("getCompetitions()");
    	
    	Map<String,String> pathParamsMap=new HashMap<>();
    	pathParamsMap.put("competitionId", String.valueOf(competitionId));
    	RestRequest request=new RestRequest();
    	request.setUrl("http://api.football-data.org/v1/competitions/{competitionId}");
    	request.setMethod(HttpMethod.GET);
    	request.setPathParams(pathParamsMap);    	
    	return restHandler.execute(request,new ParameterizedTypeReference<Competition>() {
		});
    }
    
    public Mono<TeamsResponse> getTeamsByCompetition(Integer competitionId) {
    	logger.info("getTeamsByCompetition()");
    	
    	Map<String,String> pathParamsMap=new HashMap<>();
    	pathParamsMap.put("competitionId", String.valueOf(competitionId));
    	RestRequest request=new RestRequest();
    	request.setUrl("http://api.football-data.org/v1/competitions/{competitionId}/teams");
    	request.setMethod(HttpMethod.GET);
    	request.setPathParams(pathParamsMap);    	
    	return restHandler.execute(request,new ParameterizedTypeReference<TeamsResponse>() {
		});
    }
    
    public Mono<FixtureResponse> getFixturesByCompetition(Integer competitionId) {
    	logger.info("getFixturesByCompetition()");
    	
    	Map<String,String> pathParamsMap=new HashMap<>();
    	pathParamsMap.put("competitionId", String.valueOf(competitionId));
    	RestRequest request=new RestRequest();
    	request.setUrl("http://api.football-data.org/v1/competitions/{competitionId}/fixtures");
    	request.setMethod(HttpMethod.GET);
    	request.setPathParams(pathParamsMap); 
    	Mono<FixtureResponse> fixtures= restHandler.execute(request,new ParameterizedTypeReference<FixtureResponse>() {
		});    	
    	Mono<TeamsResponse> teams= getTeamsByCompetition(competitionId);
    	return Mono.zip(fixtures, teams, new BiFunction<FixtureResponse, TeamsResponse, FixtureResponse>() {

			@Override
			public FixtureResponse apply(FixtureResponse t, TeamsResponse u) {
				
				u.getTeams().stream().forEach(team->{
					logger.info("Team::getNam:"+team.getName());
					logger.info("Team::getCrestUrl:"+team.getCrestUrl());
				});
				Map<String, String> teamCrest=u.getTeams().stream().collect(Collectors.toMap(Team::getName, Team::getCrestUrl));
				t.getFixtures().stream().forEach(new Consumer<Fixture>() {

					@Override
					public void accept(Fixture f) {						
						f.setHomeCrest(teamCrest.get(f.getHomeTeamName()));
						f.setAwayCrest(teamCrest.get(f.getAwayTeamName()));
					}
				});
				return t;
			}
		});   	
    }
    
    
    public Mono<LeagueTable> getTableByCompetition(Integer competitionId) {
    	logger.info("getTableByCompetition()");    	
    	Map<String,String> pathParamsMap=new HashMap<>();
    	pathParamsMap.put("competitionId", String.valueOf(competitionId));
    	RestRequest request=new RestRequest();
    	request.setUrl("http://api.football-data.org/v1/competitions/{competitionId}/leagueTable");
    	request.setMethod(HttpMethod.GET);
    	request.setPathParams(pathParamsMap);    	
    	return restHandler.execute(request,new ParameterizedTypeReference<LeagueTable>() {
		});    	
    }
    
}
