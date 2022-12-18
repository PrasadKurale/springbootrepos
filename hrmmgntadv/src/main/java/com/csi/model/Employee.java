package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue

    @Column(name = "emp_id")
    private int empId;

    @NotNull
    @Pattern(regexp="[A-Za-z]*", message="Employee First Name should not contain space and special characters")
    @Column(name = "emp_first_name")
    private String empFirstName;

    @NotNull
    @Pattern(regexp="[A-Za-z]*", message="Employee Last Name should not contain space and special characters")
    @Column(name = "emp_last_name")
    private String empLastName;

    @Column(name = "emp_address")
    private String empAddress;

    @Column(name = "emp_salary")
    private double empSalary;

    @Pattern(regexp = "(\\+91|0)[0-9]{10}", message = "Please enter correct contact number")
    @Column(name = "emp_contact_number", unique = true)
    private String empContactNumber;

    @Column(name = "emp_dob")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    private Date empDOB;

    @Column(name = "emp_email_id", unique = true)
    @Email(message = "Email must be valid/correct")
    private String empEmailId;

    @Size(min = 4, message = "Password should be at least 4 character")
    @Column(name = "emp_password")
    private String empPassword;


}
