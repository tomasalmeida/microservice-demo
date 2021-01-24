package com.demo.ms.search.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

import com.demo.ms.search.person.entities.PersonEntity;
import com.demo.ms.search.person.entities.QPersonEntity;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

public interface PersonRepository extends
        JpaRepository<PersonEntity, Long>,
        JpaSpecificationExecutor<PersonEntity>,
        QuerydslPredicateExecutor<PersonEntity>,
        QuerydslBinderCustomizer<QPersonEntity> {

    @Override
    default void customize(final QuerydslBindings bindings, final QPersonEntity qPersonEntity) {
        // Define the default binding for String properties to be a case insensitive contains match.
        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }

    List<PersonEntity> findByFirstname(String name);

    List<PersonEntity> findByFirstnameOrLastname(String firstName, String lastName);

    @Query(nativeQuery = true, value = "SELECT * FROM person_data WHERE person_data.id IN (SELECT p.id FROM person_data p,  JSONB_ARRAY_ELEMENTS(p.pets) pet WHERE UPPER(pet->>'name') LIKE UPPER(?1))")
    List<PersonEntity> findByPetName(String name);

}
