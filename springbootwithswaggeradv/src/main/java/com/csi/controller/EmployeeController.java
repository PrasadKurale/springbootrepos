package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Rest APIs for Employee- HRM Application")
@RestController
@RequestMapping("/")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @ApiOperation(value = "Create Post REST API for save data")
    @PostMapping("/savedata")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee){

        log.info("###########Trying to save data for Employee : "+ employee.getEmpName());
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @ApiOperation(value = "Create GET REST API for get all data")
    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @ApiOperation(value = "Create GET REST API for get data by name")
    @GetMapping("/getdatabyname/{empName}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empName){
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));
    }

    @ApiOperation(value = "Create REST API for get data by Id")
    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Employee> getDataById(@PathVariable long empId){
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId).get());
    }

    @ApiOperation(value = "Create PUT REST API for update data")
    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable long empId, @RequestBody Employee employee) throws RecordNotFoundException {

        //

        Employee employee1 = employeeServiceImpl.getDataById(empId).orElseThrow(()-> new RecordNotFoundException("Employee Id does not exist"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        return ResponseEntity.ok(employeeServiceImpl.updateData(employee1));
    }

    @ApiOperation(value = "Create DELETE REST API for delete data by Id")
    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable long empId){
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
    @GetMapping
    public string sayHello()
        {
            return "WELCOME TO CSI";
        }



}
