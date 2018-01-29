package com.src.kick.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Competition implements Serializable {

	
	private Map _links;
	private String caption;
	private Integer id;
	private String league;
	private String year;
	private Integer currentMatchday;
	private Integer numberOfMatchdays;
	private Integer numberOfTeams;
	private Integer numberOfGames;
	private Date lastUpdated;
	
	public Map get_links() {
		return _links;
	}
	public void set_links(Map _links) {
		this._links = _links;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Integer getCurrentMatchday() {
		return currentMatchday;
	}
	public void setCurrentMatchday(Integer currentMatchday) {
		this.currentMatchday = currentMatchday;
	}
	public Integer getNumberOfMatchdays() {
		return numberOfMatchdays;
	}
	public void setNumberOfMatchdays(Integer numberOfMatchdays) {
		this.numberOfMatchdays = numberOfMatchdays;
	}
	public Integer getNumberOfTeams() {
		return numberOfTeams;
	}
	public void setNumberOfTeams(Integer numberOfTeams) {
		this.numberOfTeams = numberOfTeams;
	}
	public Integer getNumberOfGames() {
		return numberOfGames;
	}
	public void setNumberOfGames(Integer numberOfGames) {
		this.numberOfGames = numberOfGames;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_links == null) ? 0 : _links.hashCode());
		result = prime * result + ((caption == null) ? 0 : caption.hashCode());
		result = prime * result + ((currentMatchday == null) ? 0 : currentMatchday.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result + ((league == null) ? 0 : league.hashCode());
		result = prime * result + ((numberOfGames == null) ? 0 : numberOfGames.hashCode());
		result = prime * result + ((numberOfMatchdays == null) ? 0 : numberOfMatchdays.hashCode());
		result = prime * result + ((numberOfTeams == null) ? 0 : numberOfTeams.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competition other = (Competition) obj;
		if (_links == null) {
			if (other._links != null)
				return false;
		} else if (!_links.equals(other._links))
			return false;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (currentMatchday == null) {
			if (other.currentMatchday != null)
				return false;
		} else if (!currentMatchday.equals(other.currentMatchday))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (league == null) {
			if (other.league != null)
				return false;
		} else if (!league.equals(other.league))
			return false;
		if (numberOfGames == null) {
			if (other.numberOfGames != null)
				return false;
		} else if (!numberOfGames.equals(other.numberOfGames))
			return false;
		if (numberOfMatchdays == null) {
			if (other.numberOfMatchdays != null)
				return false;
		} else if (!numberOfMatchdays.equals(other.numberOfMatchdays))
			return false;
		if (numberOfTeams == null) {
			if (other.numberOfTeams != null)
				return false;
		} else if (!numberOfTeams.equals(other.numberOfTeams))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Competition [_links=" + _links + ", caption=" + caption + ", id=" + id + ", league=" + league
				+ ", year=" + year + ", currentMatchday=" + currentMatchday + ", numberOfMatchdays=" + numberOfMatchdays
				+ ", numberOfTeams=" + numberOfTeams + ", numberOfGames=" + numberOfGames + ", lastUpdated="
				+ lastUpdated + "]";
	}
	
	
	
	
	
}
