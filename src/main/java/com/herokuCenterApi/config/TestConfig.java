package com.herokuCenterApi.config;

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
		Restriction rest1 = new Restriction(null, "00000000000");
		Restriction rest2 = new Restriction(null, "11111111111");
		Restriction rest3 = new Restriction(null, "22222222222");
		Restriction rest4 = new Restriction(null, "33333333333");
		
		restrictionRepository.saveAll(Arrays.asList(rest1, rest2, rest3, rest4));
	}
	
	
}
