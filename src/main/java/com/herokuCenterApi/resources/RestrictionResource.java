package com.herokuCenterApi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Restriction> insert(@RequestBody Restriction rest){
		rest = service.insert(rest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rest.getId()).toUri();
		return ResponseEntity.created(uri).body(rest);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Restriction> update(@PathVariable Long id, @RequestBody Restriction rest){
		rest = service.update(id, rest);
		return ResponseEntity.ok().body(rest);
	}
}
