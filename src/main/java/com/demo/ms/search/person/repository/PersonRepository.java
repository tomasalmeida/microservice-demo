package com.demo.ms.search.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ms.search.person.entities.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
