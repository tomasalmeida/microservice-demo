package com.demo.ms.search.person.api;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.PATH;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Operation(summary = "Search a person by id", tags = { "Person" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person found."),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Person not found")
    })
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Person> searchPersonsById(
            @Parameter(required = true, in = PATH) @PathVariable(value = "personId") final long personId);

    @Operation(summary = "Search a person by name", tags = { "Person" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person found."),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Person not found")
    })
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/searchByFirstName", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Person>> searchPersonsByFirstName(
            @RequestParam(value = "name") final String name);

    @Operation(summary = "Search a person by name or last name", tags = { "Person" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person found."),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Person not found")
    })
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/searchByFirstNameOrLastName", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Person>> searchPersonsByFirstNameOrLastName(
            @RequestParam(value = "firstName", required = false) final String firstName,
            @RequestParam(value = "lastName", required = false) final String lastName);

}
