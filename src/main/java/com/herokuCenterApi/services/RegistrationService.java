package com.herokuCenterApi.services;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuCenterApi.entities.Registration;
import com.herokuCenterApi.entities.Restriction;
import com.herokuCenterApi.repositories.RegistrationRepository;
import com.herokuCenterApi.repositories.RestrictionRepository;
import com.herokuCenterApi.services.exceptions.ResourceNotFoundException;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	@Autowired
	private RestrictionRepository restrictionRepository;
	
	public List<Registration> findAll(){
		return registrationRepository.findAll();
	}
	
	public Registration findById(Long id) {
		Optional<Registration> opt = registrationRepository.findById(id);
		return opt.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Boolean findByDoc(String doc) {
		List<Restriction> object = restrictionRepository.findAll();
		Boolean active = false;
		
		for(Restriction person : object) {
			if(person.getDocumentNumber().equals(doc)) {
				active = true;
				break;
			}
		}
		return active;
	}
	
	public Registration insert(Registration reg) {
		reg.setCreatedAt(Instant.now());
		
		try {
			int age = calculateAge(reg.getBirthDate());
			
			if(age > 17) {
				String document = reg.getDocument();
				
				Boolean doc = findByDoc(document);
				
				if(!doc) {
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
					reg.setDecision("DISAPPROVED - Document");
					reg.setBankCode(0);
				}
			} else {
				reg.setDecision("DISAPPROVED - Age");
				reg.setBankCode(0);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
				
		return registrationRepository.save(reg);
	}
	
	private Integer calculateAge(Date birth) {
		int age = 0;
		
		try {
			Calendar today = Calendar.getInstance();
			Calendar dateOfBirth = new GregorianCalendar();
			
			dateOfBirth.setTime(birth);
			age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
			dateOfBirth.add(Calendar.YEAR, age);
			
			if(today.before(dateOfBirth)) {
				age--;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		return age;
	}
}
