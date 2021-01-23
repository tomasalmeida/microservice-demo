package com.demo.ms.search.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.demo.ms.search.person.entities.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long>, JpaSpecificationExecutor<PersonEntity> {

    List<PersonEntity> findByFirstname(String name);

    List<PersonEntity> findByFirstnameOrLastname(String firstName, String lastName);
}
