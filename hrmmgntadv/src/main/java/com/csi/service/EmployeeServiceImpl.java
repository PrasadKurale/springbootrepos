package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee signUp(Employee employee){
        return employeeDaoImpl.signUp(employee);
    }

    public boolean signIn(String empEmailId, String empPassword){

        return employeeDaoImpl.signIn(empEmailId, empPassword);
    }

    public List<Employee> saveAllData(List<Employee> employees){
        return employeeDaoImpl.saveAllData(employees);
    }

    public Optional<Employee> getDataById(int empId){
        return employeeDaoImpl.getDataById(empId);
    }

    public List<Employee> getAllData(){
        return employeeDaoImpl.getAllData();
    }

    public List<Employee> getDataByUsingAnyInput(Employee employee){



        return employeeDaoImpl.getDataByUsingAnyInput(employee);
    }

    public List<Employee> getDataByName(String empFirstName){
        return employeeDaoImpl.getDataByName(empFirstName);
    }

    public List<Employee> sortByName(){
        return employeeDaoImpl.sortByName();

    }

    public List<Employee> filterDataBySalary(double empSalary){
        return employeeDaoImpl.filterDataBySalary(empSalary);

    }

    public Employee updateData(Employee employee){
        return employeeDaoImpl.updateData(employee);
    }

    public void deleteDataById(int empId){

        employeeDaoImpl.deleteDataById(empId);
    }

    public void deleteAllData(){
        employeeDaoImpl.deleteAllData();
    }
}
