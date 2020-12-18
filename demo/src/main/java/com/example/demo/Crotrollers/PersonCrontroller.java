package com.example.demo.Crotrollers;

import com.example.demo.Models.Person;
import com.example.demo.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.POST})
@RestController
@RequestMapping("api/personas")
public class PersonCrontroller {
@Autowired
    private PersonService personService;

@PostMapping
    public Person createperson(@RequestBody Person person){
           return personService.inserPerson(person);
}

@PutMapping("{personId}")
    public Person updateperson(@PathVariable (name = "personId",required = true)long personId, @RequestBody Person person){
  return personService.updatePerson(personId,person);
}
@DeleteMapping ("{personoId}")
    public  void delelteperson (@PathVariable (name = "personId",required = true)long personId){
    personService.deleteOne(personId);
}
@GetMapping ()
    public List<Person>findAll(){
    return personService.findAll();
}

@GetMapping("persona/{age}")
public List<Person> findAllByAge(@PathVariable(name = "age",required = true)int age){
    return personService.findByAge(age);
}

@GetMapping("{personaID}")
public Person findOneById(@PathVariable (name ="perosnId",required = true)long personId){
    return personService.findOne(personId);
}
}
