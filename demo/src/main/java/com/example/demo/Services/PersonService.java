package com.example.demo.Services;

import com.example.demo.MOdelsDb.PersonDB;
import com.example.demo.Models.Person;
import com.example.demo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
   public PersonRepository repo;

    public Person inserPerson(Person person){

        PersonDB save = repo.save(new PersonDB(person));
        person.setId(save.getId());
        return person;
    }

    public Person updatePerson(long id ,Person person){
         PersonDB found= repo.findById(id).get();
         found.setName(person.getName());
         found.setAge(person.getAge());
         found.setHeight(person.getHeight());
        PersonDB save =repo.save(found);
        person.setId(save.getId());
        return person;
    }
    public void deleteOne(Long id){
        repo.deleteById(id);
    }

    public List<Person> findAll(){
        List <Person> data = new ArrayList<>();
        Iterator<PersonDB> iterator = repo.findAll().iterator();
        while (iterator.hasNext()){
            data.add(new Person(iterator.next()));

        }
        return data;
    }
    public List<Person> findByAge(int age){
        List <Person> data = new ArrayList<>();
        Iterator<PersonDB> iterator = repo.findpeopleage(age).iterator();
        while (iterator.hasNext()){
            data.add(new Person(iterator.next()));

        }
        return data;
    }

    public Person findOne(long id){
        Optional<PersonDB> found =repo.findById(id);
        PersonDB personDB = found.get();
        return  new Person(personDB);
    }
}
