package com.herokuCenterApi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuCenterApi.entities.Restriction;
import com.herokuCenterApi.services.RestrictionService;

@RestController
@RequestMapping(value = "/restriction")
public class RestrictionResource {

	@Autowired
	private RestrictionService service;
	
	@GetMapping
	public ResponseEntity<List<Restriction>> findAll(){
		List<Restriction> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Restriction> findById(@PathVariable Long id){
		Restriction rest = service.findById(id);
		return ResponseEntity.ok().body(rest);
	}
}
