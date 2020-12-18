package com.example.APICRUD30.controller;

import com.example.APICRUD30.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.APICRUD30.models.Department;
import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("departments")
public class DepartmentsController {

    @Autowired
    private DepartmentService depService;

    @PostMapping
    public Department createDepartment(@RequestBody Department dep){
        return depService.insertDepartment(dep);
    }

    @PutMapping("{depId}")
    public void updateDepartment(@PathVariable (name = "depId", required = true)long depId,
                                 @RequestBody Department dep){
        depService.updateDepartment(depId, dep);
    }

    @DeleteMapping("{depId}")
    public void deleteRecord(@PathVariable (name = "depId", required = true) long depId){
        depService.deleteOne(depId);
    }

    @GetMapping
    public List<Department> getDepartments(){
        return depService.findAll();
    }

    @GetMapping("{depId}")
    public Department getOneDepartments(@PathVariable (name = "depId", required = true) long depId){
        return depService.findOne(depId);
    }


}
