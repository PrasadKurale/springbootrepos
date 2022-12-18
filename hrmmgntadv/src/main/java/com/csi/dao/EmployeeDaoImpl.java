package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;

    public Employee signUp(Employee employee){
        return employeeRepositoryImpl.save(employee);
    }

    public boolean signIn(String empEmailId, String empPassword){
        boolean flag= false;
        for(Employee employee: employeeRepositoryImpl.findAll()){
            if(employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)){
                flag=true;
            }
        }
        return flag;
    }

    public List<Employee> saveAllData(List<Employee> employees){
        return employeeRepositoryImpl.saveAll(employees);
    }

    public Optional<Employee> getDataById(int empId){
        return employeeRepositoryImpl.findById(empId);
    }

    public List<Employee> getAllData(){
        return employeeRepositoryImpl.findAll();
    }

    public List<Employee> getDataByUsingAnyInput(Employee employee){

        List<Employee> employeeList = new ArrayList<>();
        for(Employee emp: employeeRepositoryImpl.findAll()){
            if(emp.getEmpId()== employee.getEmpId()
            || emp.getEmpFirstName().equals(employee.getEmpFirstName())
            || emp.getEmpContactNumber()== employee.getEmpContactNumber()
            || emp.getEmpEmailId().equals(employee.getEmpEmailId())){
                employeeList.add(emp);
            }
        }
        return employeeList;
    }

    public List<Employee> getDataByName(String empFirstName){
        return employeeRepositoryImpl.findByEmpFirstName(empFirstName);
    }

    public List<Employee> sortByName(){
        return employeeRepositoryImpl.findAll().stream().sorted((e1, e2)-> e1.getEmpFirstName().compareTo(e2.getEmpFirstName())).collect(Collectors.toList());

    }

    public List<Employee> filterDataBySalary(double empSalary){
        return employeeRepositoryImpl.findAll().stream().filter(emp-> emp.getEmpSalary()>=empSalary).collect(Collectors.toList());

    }

    public Employee updateData(Employee employee){
         return employeeRepositoryImpl.save(employee);
    }

    public void deleteDataById(int empId){

        employeeRepositoryImpl.deleteById(empId);
    }

    public void deleteAllData(){
        employeeRepositoryImpl.deleteAll();
    }
}
