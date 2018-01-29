package com.src.kick;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.kick.domain.Player;
import com.src.kick.domain.Team;
import com.src.kick.service.TeamsService;
import com.src.kick.service.TwitterService;

@RestController
public class TeamsController {

	@Autowired
    private TwitterService twitterService;
	
	@Autowired
    private TeamsService teamService;

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/teams")
	public List<Team> getTopTeams() {
		List<Team> teams=new ArrayList<>();
		Team team1=new Team();
		team1.setId(1);
		team1.setName("Liverpool");
		team1.setUrl("http://www.liverpoolfc.com/");
		teams.add(team1);
		Team team2=new Team();
		team2.setId(2);
		team2.setName("Arsenal");
		team2.setUrl("http://www.liverpoolfc.com/");
		teams.add(team2);
		return teams;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/teams/{teamId}")
	public Team getTeam(@PathVariable(value="teamId",required=true) Integer teamId) {
		return teamService.getTeam(teamId).block();
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/teams/{teamId}/players")
	public List<Player> getPlayersByTeam(@PathVariable(value="teamId",required=true) Integer teamId) {
		return teamService.getPlayers(teamId).block().getPlayers();		
	}
	 
	 
	
	 
	
}
