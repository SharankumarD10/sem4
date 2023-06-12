package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.Service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/books")
public class OpenApiController {

	@Autowired
	EmployeeService employeeService;
	
	@Operation(summary = "Creates a new Bookentry")
	@ApiResponses(value = {@ApiResponse(responseCode = "201" , description = "Book entry created successfully"),
		                   @ApiResponse(responseCode = "400", description = "Entry is invalid")})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<EmployeeEntity> create(final @RequestBody EmployeeEntity employee)
	{
		EmployeeEntity createEmployee = employeeService.create(employee);
		return ResponseEntity.ok(createEmployee);
	}
	
	@Operation(summary = "Get an Book data with given id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "getting Book info successfully"),
			               @ApiResponse(responseCode = "401", description = "invalid Details"),
			               @ApiResponse(responseCode = "404", description = "Book not found")})
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Optional<EmployeeEntity>> read(final @PathVariable Long id){
		Optional<EmployeeEntity> createdEmployee = employeeService.read(id);
		return ResponseEntity.ok(createdEmployee);
	}
	
	@Operation(summary = "Update the Book by given id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Book details updated successfully"),
			               @ApiResponse(responseCode = "400", description = "Book is invalid"),
			               @ApiResponse(responseCode = "404", description = "Book not found")})
	@PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<EmployeeEntity> update(final @RequestBody EmployeeEntity employee)
	throws JsonProcessingException
	{
		final EmployeeEntity updatedEmployee = employeeService.update(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@Operation(summary = "Delete the Book by given id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Book deleted successfully"),
			               @ApiResponse(responseCode = "401", description = "invalid details"),
			               @ApiResponse(responseCode = "404", description = "Book not found")})
	@DeleteMapping(value = "/{id}")
	public void delete(final @PathVariable Long id) {
		employeeService.delete(id);
	}
	
}