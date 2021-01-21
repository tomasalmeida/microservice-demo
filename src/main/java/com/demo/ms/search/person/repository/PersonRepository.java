package com.demo.ms.search.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ms.search.person.entities.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    List<PersonEntity> findByFirstname(String name);

    List<PersonEntity> findByFirstnameOrLastname(String firstName, String lastName);
}
