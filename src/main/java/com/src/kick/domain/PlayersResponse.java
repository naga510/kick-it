package com.src.kick.domain;

import java.util.List;

public class PlayersResponse {

	private Integer count;
	private List<Player> players;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
}
