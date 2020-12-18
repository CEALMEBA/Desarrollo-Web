package com.example.APICRUD30.controller;


import com.example.APICRUD30.services.EmployeeService;
import com.example.APICRUD30.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService empApplication;

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(empApplication.createEmployee(employee));
    }

    @PutMapping("{employeeId}")
    public ResponseEntity updateEmployee(@PathVariable (name = "employeeId", required = true) long employeeId,
                                         @RequestBody Employee employee){
        empApplication.updateEmployee(employeeId,employee);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{employeeId}")
    public ResponseEntity deleteEmployee(@PathVariable(name = "employeeId", required = true) long employeeId){
        empApplication.deleteEmployee(employeeId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity findEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(empApplication.findAll());
    }

    @GetMapping("{employeeId}")
    public ResponseEntity getOneEmployee(@PathVariable (name = "employeeId", required = true) long employeeId){
        return ResponseEntity.status(HttpStatus.OK).body(empApplication.getOneEmployee(employeeId));
    }

}
