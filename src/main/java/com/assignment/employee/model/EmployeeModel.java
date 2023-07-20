package com.assignment.employee.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Employee")
@Data @AllArgsConstructor @NoArgsConstructor
public class EmployeeModel {
    
    @Id
    private String id;
    @NotBlank(message = "Employee Name is mandatory")
    private String employeeName;
    @NotBlank(message = "Phone Number is mandatory")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone Number should be 10 digits")
    private String phoneNumber;
    @Email(message = "Email should be valid")
    @NotBlank(message = "email id is mandatory")
    private String email;
    
    private String reportsTo;
    
    private String profileImage;
}
