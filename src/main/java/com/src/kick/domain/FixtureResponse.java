package com.src.kick.domain;

import java.util.List;

public class FixtureResponse {

	private Integer count;
	private List<Fixture> fixtures;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<Fixture> getFixtures() {
		return fixtures;
	}
	public void setFixtures(List<Fixture> fixtures) {
		this.fixtures = fixtures;
	}
	
	
}
