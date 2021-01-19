package com.demo.ms.search.person.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;

import com.demo.ms.search.person.model.Pet;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "person_data")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstname;
    String lastname;
    String email;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    List<Pet> pets;

    @CreationTimestamp
    @Column(updatable = false)
    LocalDateTime created;

    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
