package com.herokuCenterApi.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuCenterApi.entities.Registration;
import com.herokuCenterApi.repositories.RegistrationRepository;
import com.herokuCenterApi.services.exceptions.ResourceNotFoundException;
import com.herokuCenterApi.utils.Utils;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	public List<Registration> findAll(){
		return registrationRepository.findAll();
	}
	
	public Registration findById(Long id) {
		Optional<Registration> opt = registrationRepository.findById(id);
		return opt.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Registration insert(Registration reg) {
		reg.setCreatedAt(Instant.now());
		
		Utils util = new Utils();
		int age = util.calculateAge(reg.getBirthDate());
		
		if(age > 17) {
			reg.setDecision("APPROVED");
			
			Double value = reg.getSalary();
			
			if(value <= 1100.00) {
				reg.setBankCode(1);
			} else if(value > 1100.00 && value < 3300.00) {
				reg.setBankCode(2);
			} else if(value > 3300.00 && value < 6600.00) {
				reg.setBankCode(3);
			} else {
				reg.setBankCode(4);
			}
		} else {
			reg.setDecision("DISAPPROVED");
			reg.setBankCode(0);
		}
		return registrationRepository.save(reg);
	}
}
