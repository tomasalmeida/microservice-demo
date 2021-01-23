package com.demo.ms.search.person.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Pair;

import com.demo.ms.search.person.entities.PersonEntity;

public class PersonSpecification implements Specification<PersonEntity> {

    private Pair<String, String> parameter;

    public PersonSpecification(final String column, final String value) {
        super();
        this.parameter = Pair.of(column, value);
    }

    @Override
    public Predicate toPredicate(final Root<PersonEntity> root, final CriteriaQuery<?> criteriaQuery,
            final CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.<String>get(parameter.getFirst()), "%" + parameter.getSecond() + "%");
    }
}
