package com.demo.ms.search.person.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import com.demo.ms.search.person.entities.PersonEntity;

import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({
        @Spec(path = "firstname", spec = Like.class),
        @Spec(path = "lastName", spec = Like.class),
        @Spec(path = "email", spec = Like.class)})
public interface PersonAnnotatedSpecification extends Specification<PersonEntity> {
}
