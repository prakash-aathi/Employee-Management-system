package com.assignment.employee.services;


import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assignment.employee.model.EmployeeModel;
import com.assignment.employee.repository.EmployeeRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ResponseEntity<?> addEmployee(EmployeeModel employeeRequest) throws JsonProcessingException {

        EmployeeModel employee = employeeRepo.save(employeeRequest);
        return new ResponseEntity<>(objectMapper.writeValueAsString(employee.getId()), HttpStatus.CREATED );
    }

    @Override
    public Page<EmployeeModel> getAllEmployees(int page, int pageSize, String sortBy) {
        Sort sort = Sort.by(sortBy);
        PageRequest pageable = PageRequest.of(page, pageSize, sort);
        return employeeRepo.findAll(pageable);
     }

    @Override
    public ResponseEntity<?> deleteById(String id) throws JsonProcessingException {
        employeeRepo.deleteById(id);
        return new ResponseEntity<>(objectMapper.writeValueAsString("Deleted SuccessFully"), HttpStatus.OK );
    }

    @Override
    public ResponseEntity<?> changeById(EmployeeModel employeeModel) {
        EmployeeModel employee = employeeRepo.findById(employeeModel.getId())
                .orElseThrow( ()-> new RuntimeException("Employee Not Found"));
        
        employee.setEmail(employeeModel.getEmail());
        employee.setEmployeeName(employeeModel.getEmployeeName());
        employee.setPhoneNumber(employeeModel.getPhoneNumber());
        employee.setProfileImage(employeeModel.getProfileImage());
        employee.setReportsTo(employeeModel.getReportsTo());

        return new ResponseEntity<>(employeeRepo.save(employee), HttpStatus.OK );
    }

    @Override
    public ResponseEntity<?> getReporting(String id, int level) {
        return new ResponseEntity<>(getReportingManager(id, level), HttpStatus.OK);
    }
    
    public ResponseEntity<?> getReportingManager(String id, int level) {
        Optional<EmployeeModel> employee = employeeRepo.findById(id);

        if (!employee.isPresent()) {
            return new ResponseEntity<>("Manager not found at level ", HttpStatus.NOT_FOUND);
        }
        
        if (level == 0) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return getReportingManager(employee.get().getReportsTo(), level - 1);
    }

   
    
}
