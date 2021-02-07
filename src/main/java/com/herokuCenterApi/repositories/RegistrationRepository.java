package com.herokuCenterApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herokuCenterApi.entities.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long>{

}
