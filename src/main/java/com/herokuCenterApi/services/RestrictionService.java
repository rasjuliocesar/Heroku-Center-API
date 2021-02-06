package com.herokuCenterApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.herokuCenterApi.entities.Restriction;
import com.herokuCenterApi.repositories.RestrictionRepository;
import com.herokuCenterApi.services.exceptions.DatabaseException;
import com.herokuCenterApi.services.exceptions.ResourceNotFoundException;

@Service
public class RestrictionService {

	@Autowired
	private RestrictionRepository repository;
	
	public List<Restriction> findAll(){
		return repository.findAll();
	}
	
	public Restriction findById(Long id) {
		Optional<Restriction> opt = repository.findById(id);
		return opt.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Restriction insert(Restriction rest) {
		return repository.save(rest);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Restriction update(Long id, Restriction rest) {
		Restriction obj = repository.getOne(id);
		updateData(obj, rest);
		return repository.save(obj);
	}

	private void updateData(Restriction rest, Restriction obj) {
		rest.setDocumentNumber(obj.getDocumentNumber());
	}
}
