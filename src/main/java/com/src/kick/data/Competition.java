package com.src.kick.data;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Document(collection="competition")
public class Competition {

	private String caption;
	private @Id Integer id;
	private String league;
	private String year;
	private Integer currentMatchday;
	private Integer numberOfMatchdays;
	private Integer numberOfTeams;
	private Integer numberOfGames;
	private Date lastUpdated;
	
}
