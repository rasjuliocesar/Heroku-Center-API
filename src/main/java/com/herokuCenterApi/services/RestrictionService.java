package com.herokuCenterApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuCenterApi.entities.Restriction;
import com.herokuCenterApi.repositories.RestrictionRepository;

@Service
public class RestrictionService {

	@Autowired
	private RestrictionRepository repository;
	
	public List<Restriction> findAll(){
		return repository.findAll();
	}
	
	public Restriction findById(Long id) {
		Optional<Restriction> opt = repository.findById(id);
		return opt.get();
	}
}
