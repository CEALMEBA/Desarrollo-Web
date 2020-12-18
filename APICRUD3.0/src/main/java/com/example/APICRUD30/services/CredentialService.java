package com.example.APICRUD30.services;

import com.example.APICRUD30.models.Credential;
import com.example.APICRUD30.repository.CredentialDbModel;

import com.example.APICRUD30.repository.CredentialRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CredentialService {

    @Autowired
    private CredentialRepository credentialRepo;

    public Credential findRecord(String username, String password){
        CredentialDbModel credential = credentialRepo.findCredential(username, password);
        return new Credential(credential);
    }

    public Credential getOneRecord(int id){
        CredentialDbModel credentialDbModel = credentialRepo.findById(id).get();
        return new Credential(credentialDbModel);
    }
}
