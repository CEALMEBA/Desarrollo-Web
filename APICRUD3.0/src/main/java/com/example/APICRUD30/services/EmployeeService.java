package com.example.APICRUD30.services;

import com.example.APICRUD30.models.Employee;
import com.example.APICRUD30.repository.EmployeeDbModel;
import com.example.APICRUD30.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    public EmployeeService() {
    }


    public Employee createEmployee(Employee employee){
        EmployeeDbModel savedEmployee = employeeRepo.save(new EmployeeDbModel(employee.getId(), employee.getName(), employee.getLastName(), employee.getUsername(), employee.getEmail(), employee.getPhoneNumber()));
        employee.setId(savedEmployee.getId());
        return employee;
    }


    public void updateEmployee(Long employeeId, Employee employee){
        Optional<EmployeeDbModel> optEmployee = employeeRepo.findById(employeeId);
        EmployeeDbModel employeeFound = optEmployee.get();
        employeeFound.setName(employee.getName());
        employeeFound.setLastName(employee.getLastName());
        employeeFound.setUsername(employee.getUsername());
        employeeFound.setEmail(employee.getEmail());
        employeeFound.setPhoneNumber(employee.getPhoneNumber());
        employeeRepo.save(employeeFound);
    }



    public List<Employee> findAll(){
        Iterator<EmployeeDbModel> records = employeeRepo.findAll().iterator();
        List<Employee> employees = new ArrayList();
        while (records.hasNext()){
            employees.add(new Employee(records.next()));
        }
        return employees;
    }


    public void deleteEmployee(long id){
        employeeRepo.deleteById(id);
    }


    public Employee getOneEmployee(long id){
        Optional<EmployeeDbModel> byId = employeeRepo.findById(id);
        EmployeeDbModel employeeDbModel = byId.get();
        Employee emp = new Employee(employeeDbModel);
        return emp;
    }


}
