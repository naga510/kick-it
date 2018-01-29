package com.src.kick.domain;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Fixture {
	
	private Map _links;
	private Date date;
	private String status;
	private Integer matchday;
	private String homeTeamName;
	private String homeCrest;
	private String awayCrest;	
	private String awayTeamName;
	private FixtureResult result;
	private FixtureOdds odds;
	
	
	public Map get_links() {
		return _links;
	}
	public void set_links(Map _links) {
		this._links = _links;
	}
	public String getHomeCrest() {
		return homeCrest;
	}
	public void setHomeCrest(String homeCrest) {
		this.homeCrest = homeCrest;
	}
	public String getAwayCrest() {
		return awayCrest;
	}
	public void setAwayCrest(String awayCrest) {
		this.awayCrest = awayCrest;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getMatchday() {
		return matchday;
	}
	public void setMatchday(Integer matchday) {
		this.matchday = matchday;
	}
	public String getHomeTeamName() {
		return homeTeamName;
	}
	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}
	public String getAwayTeamName() {
		return awayTeamName;
	}
	public void setAwayTeamName(String awayTeamName) {
		this.awayTeamName = awayTeamName;
	}
	public FixtureResult getResult() {
		return result;
	}
	public void setResult(FixtureResult result) {
		this.result = result;
	}
	public FixtureOdds getOdds() {
		return odds;
	}
	public void setOdds(FixtureOdds odds) {
		this.odds = odds;
	}
	
	
}
