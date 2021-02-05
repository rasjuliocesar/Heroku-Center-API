package com.herokuCenterApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.herokuCenterApi.entities.Restriction;
import com.herokuCenterApi.repositories.RestrictionRepository;

public class RestrictionService {

	@Autowired
	private RestrictionRepository repository;
	
	public List<Restriction> findAll(){
		return repository.findAll();
	}
}
