package com.assignment.employee.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.employee.model.EmployeeModel;
import com.assignment.employee.services.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeModel employeeRequest)
            throws JsonProcessingException {
        return employeeService.addEmployee(employeeRequest);
    }
    
    @GetMapping
    public ResponseEntity<?> getAllEmployees(@RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
                Page<EmployeeModel> employees = employeeService.getAllEmployees(page, pageSize, sortBy);
                return ResponseEntity.ok(employees);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(@RequestParam String id) throws JsonProcessingException {
        return employeeService.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<?> changeById(@RequestBody EmployeeModel employeeModel) {
        return employeeService.changeById(employeeModel);
    }
    
    @GetMapping("/reporting")
    public ResponseEntity<?> getReporting(@RequestParam String id, @RequestParam int level) {
        return employeeService.getReporting(id, level);
    }
     
}
