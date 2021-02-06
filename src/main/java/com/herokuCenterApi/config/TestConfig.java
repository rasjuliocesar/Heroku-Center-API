package com.herokuCenterApi.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.herokuCenterApi.entities.Restriction;
import com.herokuCenterApi.repositories.RestrictionRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private RestrictionRepository restrictionRepository;

	@Override
	public void run(String... args) throws Exception {
		Restriction rest1 = new Restriction(null, "00000000000", true, Instant.now(), Instant.now());
		Restriction rest2 = new Restriction(null, "11111111111", true, Instant.now(), Instant.now());
		Restriction rest3 = new Restriction(null, "22222222222", true, Instant.now(), Instant.now());
		Restriction rest4 = new Restriction(null, "33333333333", true, Instant.now(), Instant.now());
		
		restrictionRepository.saveAll(Arrays.asList(rest1, rest2, rest3, rest4));
	}
	
	
}
