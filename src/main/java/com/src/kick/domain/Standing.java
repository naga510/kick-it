package com.src.kick.domain;

public class Standing {

	private Integer position;
	private String teamName;
	private String crestURI;
	private Integer playedGames;
	private Integer points;
	private Integer goals;
	private Integer goalsAgainst;
	private Integer goalDifference;
	private Integer wins;
	private Integer draws;
	private Integer losses;
	private Performance home;
	private Performance away;
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getCrestURI() {
		return crestURI;
	}
	public void setCrestURI(String crestURI) {
		this.crestURI = crestURI;
	}
	public Integer getPlayedGames() {
		return playedGames;
	}
	public void setPlayedGames(Integer playedGames) {
		this.playedGames = playedGames;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Integer getGoals() {
		return goals;
	}
	public void setGoals(Integer goals) {
		this.goals = goals;
	}
	public Integer getGoalsAgainst() {
		return goalsAgainst;
	}
	public void setGoalsAgainst(Integer goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}
	public Integer getGoalDifference() {
		return goalDifference;
	}
	public void setGoalDifference(Integer goalDifference) {
		this.goalDifference = goalDifference;
	}
	public Integer getWins() {
		return wins;
	}
	public void setWins(Integer wins) {
		this.wins = wins;
	}
	public Integer getDraws() {
		return draws;
	}
	public void setDraws(Integer draws) {
		this.draws = draws;
	}
	public Integer getLosses() {
		return losses;
	}
	public void setLosses(Integer losses) {
		this.losses = losses;
	}
	public Performance getHome() {
		return home;
	}
	public void setHome(Performance home) {
		this.home = home;
	}
	public Performance getAway() {
		return away;
	}
	public void setAway(Performance away) {
		this.away = away;
	}
}
