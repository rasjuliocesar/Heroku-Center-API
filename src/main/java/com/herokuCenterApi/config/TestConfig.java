package com.herokuCenterApi.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.herokuCenterApi.entities.Registration;
import com.herokuCenterApi.entities.Restriction;
import com.herokuCenterApi.repositories.RegistrationRepository;
import com.herokuCenterApi.repositories.RestrictionRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private RestrictionRepository restrictionRepository;
	@Autowired
	private RegistrationRepository registrationRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Restriction rest1 = new Restriction(null, "00000000000", true, Instant.now(), Instant.now());
		Restriction rest2 = new Restriction(null, "11111111111", true, Instant.now(), Instant.now());
		Restriction rest3 = new Restriction(null, "22222222222", true, Instant.now(), Instant.now());
		Restriction rest4 = new Restriction(null, "33333333333", true, Instant.now(), Instant.now());
		
		restrictionRepository.saveAll(Arrays.asList(rest1, rest2, rest3, rest4));
		
		Registration reg1 = new Registration(1L, "Um Dois Três de Oliveira Quatro", "Boa Viagem Avenue", "51513220", "Pernambuco", "Brazil", sdf.parse("01/08/1986"), "12345678910", "+5581912345678", "1234@email.com", 1500.00, "APPROVED", 104);
		Registration reg2 = new Registration(1L, "Robert Marley", "Jamaica Avenue", "55546", "Kingston", "Jamaica", sdf.parse("06/02/1954"), "96336985200", "+504448678", "bob@email.com", 2500.00, "APPROVED", 105);
		Registration reg3 = new Registration(1L, "Chaves Bolanos", "El Chavo del Ocho Street", "3388808", "Mexico City", "Mexico", sdf.parse("15/12/1960"), "1142888", "+1011052541", "chaves@email.com", 4500.00, "APPROVED", 106);
		Registration reg4 = new Registration(1L, "King James", "St Charles Avenue", "78050", "Los Angeles", "United States", sdf.parse("31/06/1980"), "5542210", "+15041239999", "james@email.com", 6500.00, "APPROVED", 107);
		
		registrationRepository.saveAll(Arrays.asList(reg1, reg2, reg3, reg4));
	}
	
	
}
