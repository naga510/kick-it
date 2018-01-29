package com.src.kick.domain;

import java.util.List;

public class LeagueTable {

	private String leagueCaption;
	private Integer matchDay;
	private List<Standing> standing;
	public String getLeagueCaption() {
		return leagueCaption;
	}
	public void setLeagueCaption(String leagueCaption) {
		this.leagueCaption = leagueCaption;
	}
	public Integer getMatchDay() {
		return matchDay;
	}
	public void setMatchDay(Integer matchDay) {
		this.matchDay = matchDay;
	}
	public List<Standing> getStanding() {
		return standing;
	}
	public void setStanding(List<Standing> standing) {
		this.standing = standing;
	}
	
	
}
