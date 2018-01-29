package com.src.kick.dao;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.src.kick.data.Competition;


public interface CompetitionsRepository extends ReactiveCrudRepository<Competition, Integer> {

	
}
