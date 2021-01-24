package com.demo.ms.search.person.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.ms.search.person.entities.PersonEntity;

@RepositoryRestResource(path = "personsREST")
public interface PersonDataRestRepository extends PagingAndSortingRepository<PersonEntity, Long> {

    List<PersonEntity> findByFirstname(@Param("firstname") String firstname);

}
