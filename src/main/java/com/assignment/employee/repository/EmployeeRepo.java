package com.assignment.employee.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.assignment.employee.model.EmployeeModel;

public interface EmployeeRepo extends MongoRepository<EmployeeModel, String> {

        Page<EmployeeModel> findAll(Pageable pageable);

}