package com.herokuCenterApi.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuCenterApi.entities.Restriction;

@RestController
@RequestMapping(value = "/restriction")
public class RestrictionResource {

	@GetMapping
	public ResponseEntity<Restriction> findAll(){
		Restriction rest = new Restriction(1L, "0000000000");
		return ResponseEntity.ok().body(rest);
	}
}
