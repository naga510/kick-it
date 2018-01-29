package com.src.kick.domain;

import java.util.List;

public class TeamsResponse {

	private Integer count;
	private List<Team> teams;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	
}
