package com.example.APICRUD30.controller;


import com.example.APICRUD30.models.Credential;
import com.example.APICRUD30.services.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("credentials")
public class CredentialController {

    @Autowired
    private CredentialService credentialService;

    @GetMapping("{username}/{password}")
    public Credential validateCredential(@PathVariable String username, @PathVariable String password){
        return credentialService.findRecord(username, password);
    }


}
