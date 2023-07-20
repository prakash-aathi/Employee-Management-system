package com.assignment.employee.services;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.assignment.employee.model.EmployeeModel;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface EmployeeService {

    ResponseEntity<?> addEmployee(EmployeeModel employeeRequest) throws JsonProcessingException;

    Page<EmployeeModel> getAllEmployees(int page, int pageSize, String sortBy);

    ResponseEntity<?> deleteById(String id) throws JsonProcessingException;

    ResponseEntity<?> changeById(EmployeeModel employeeModel);

    ResponseEntity<?> getReporting(String id, int level);
    

}
