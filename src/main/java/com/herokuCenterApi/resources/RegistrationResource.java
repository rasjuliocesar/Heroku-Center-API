package com.herokuCenterApi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.herokuCenterApi.entities.Registration;
import com.herokuCenterApi.services.RegistrationService;

@RestController
@RequestMapping(value = "/registration")
public class RegistrationResource {
	
	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping
	public ResponseEntity<List<Registration>> findAll(){
		List<Registration> list = registrationService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Registration> findById(@PathVariable Long id){
		Registration reg = registrationService.findById(id);
		return ResponseEntity.ok().body(reg);
	}
	
	@GetMapping(value ="/{doc}")
	public ResponseEntity<Boolean> findByDoc(@PathVariable String doc){
		Boolean reg = registrationService.findByDoc(doc);
		return ResponseEntity.ok().body(reg);
	}
	
	@PostMapping
	public ResponseEntity<Registration> insert(@RequestBody Registration reg){
		reg = registrationService.insert(reg);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reg.getId()).toUri();
		return ResponseEntity.created(uri).body(reg);
	}
}
