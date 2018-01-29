package com.src.kick.service;

import java.util.List;

import com.src.kick.domain.Player;
import com.src.kick.domain.PlayersResponse;
import com.src.kick.domain.Team;

import reactor.core.publisher.Mono;



public interface TeamsService {

	public List<Team> topTeams();
	
	public Mono<Team> getTeam(Integer teamId);
	
	public Mono<PlayersResponse> getPlayers(Integer teamId);
	
}
