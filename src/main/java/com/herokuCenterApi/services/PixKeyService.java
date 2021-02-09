package com.herokuCenterApi.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuCenterApi.entities.PixKey;
import com.herokuCenterApi.repositories.PixKeyRepository;
import com.herokuCenterApi.services.exceptions.ResourceNotFoundException;

@Service
public class PixKeyService {
	
	@Autowired
	private PixKeyRepository pixKeyRepository;
	
	public List<PixKey> findAll(){
		return pixKeyRepository.findAll();
	}

	public PixKey findById(Long id) {
		Optional<PixKey> opt = pixKeyRepository.findById(id);
		return opt.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public PixKey insert(PixKey pix) {
		pix.setCreatedAt(Instant.now());
		return pixKeyRepository.save(pix);
	}
}
