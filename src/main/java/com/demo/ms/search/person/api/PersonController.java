package com.demo.ms.search.person.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.demo.ms.search.person.model.Person;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Person with pets", description = "Demo search with micro services")
@RequestMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)

public interface PersonController {

    @Operation(summary = "Creates a new person", tags = { "Person" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Creation was successful."),
            @ApiResponse(responseCode = "500", description = "An internal Server error occurs")
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Person> createNewPerson(
            @Parameter(description = "The person that has to be saved.", required = true) @RequestBody Person person);

}
