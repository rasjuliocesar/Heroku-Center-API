package com.herokuCenterApi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.herokuCenterApi.entities.PixKey;
import com.herokuCenterApi.services.PixKeyService;

@RestController
@RequestMapping(value = "/pixkey")
public class PixKeyResource {

	@Autowired
	private PixKeyService pixKeyService;
	
	@GetMapping
	public ResponseEntity<List<PixKey>> findAll(){
		List<PixKey> list = pixKeyService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PixKey> findById(@PathVariable Long id){
		PixKey pix = pixKeyService.findById(id);
		return ResponseEntity.ok().body(pix);
	}
	
	@PostMapping
	public ResponseEntity<PixKey> insert(PixKey pix){
		pix = pixKeyService.insert(pix);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pix.getId()).toUri();
		return ResponseEntity.created(uri).body(pix);
	}
}
