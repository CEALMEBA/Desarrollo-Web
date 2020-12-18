package com.example.APICRUD30.services;

import com.example.APICRUD30.models.Department;
import  com.example.APICRUD30.repository.DepartmentDbModel;
import com.example.APICRUD30.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository depRepo;

    public DepartmentService(){}


    public Department insertDepartment(Department dep){
        DepartmentDbModel depSaved = depRepo.save(new DepartmentDbModel(dep.getId(), dep.getName(), dep.getDescription()));
        dep.setId(depSaved.getId());
        return dep;
    }


    public void updateDepartment(long id, Department dep){
        Optional<DepartmentDbModel> data = depRepo.findById(id);
        DepartmentDbModel foundDep = data.get();
        foundDep.setName(dep.getName());
        foundDep.setDescription(dep.getDescription());
        depRepo.save(foundDep);
    }


    public List<Department> findAll(){
        List<Department> departments = new ArrayList();
        Iterator<DepartmentDbModel> iterator = depRepo.findAll().iterator();
        while(iterator.hasNext()){
            departments.add(new Department(iterator.next()));
        }
        return departments;
    }


    public Department findOne(long id){
        return new Department(depRepo.findById(id).get());
    }


    public void deleteOne(long id){
        depRepo.deleteById(id);
    }

}
