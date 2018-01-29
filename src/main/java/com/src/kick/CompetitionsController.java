package com.src.kick;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.src.kick.domain.Competition;
import com.src.kick.domain.Fixture;
import com.src.kick.domain.LeagueTable;
import com.src.kick.domain.Team;
import com.src.kick.service.CompetitionService;

@RestController
public class CompetitionsController {

	private static final Logger logger = LoggerFactory.getLogger(CompetitionsController.class);
	@Autowired
	private CompetitionService competitionService;

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/competitions")
	public Iterable<Competition> getCompetitions()
	{		
		return competitionService.getCompetitions().collectList().block();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/competitions/{competitionId}")
	public Competition getDetailedCompetition(@PathVariable(value="competitionId",required=true) Integer competitionId)
	{		
		return competitionService.getDetailedCompetition(competitionId).block();
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/competitions/{competitionId}/teams")
	public List<Team> getTeamsByCompetition(@PathVariable(value="competitionId",required=true) Integer competitionId)
	{		
		return competitionService.getTeamsByCompetition(competitionId).block().getTeams();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/competitions/{competitionId}/fixtures")
	public List<Fixture> getFixturesByCompetition(@PathVariable(value="competitionId",required=true) Integer competitionId, @RequestParam(value="matchDay") Integer matchDay)
	{	
		List<Fixture> fixtures= competitionService.getFixturesByCompetition(competitionId).block().getFixtures();
		return matchDay!=null?fixtures.stream().filter(fixture-> fixture.getMatchday()==matchDay).collect(Collectors.toList()): fixtures;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/competitions/{competitionId}/leaguetable")
	public LeagueTable getTableByCompetition(@PathVariable(value="competitionId",required=true) Integer competitionId)
	{		
		return competitionService.getTableByCompetition(competitionId).block();
	}
}
