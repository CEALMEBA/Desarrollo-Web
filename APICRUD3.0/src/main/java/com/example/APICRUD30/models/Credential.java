package com.example.APICRUD30.models;

import com.example.APICRUD30.repository.CredentialDbModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Credential {
    private int id;
    private String username;
    private String password;

    public Credential(CredentialDbModel model){
        this.id = model.getId();
        this.username = model.getUsername();
        this.password = model.getPassword();
    }
}
