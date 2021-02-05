package com.herokuCenterApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herokuCenterApi.entities.Restriction;

public interface RestrictionRepository extends JpaRepository<Restriction, Long>{

}
