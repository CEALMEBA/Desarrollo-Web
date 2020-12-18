package com.example.APICRUD30.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CredentialRepository extends CrudRepository<com.example.APICRUD30.repository.CredentialDbModel , Integer> {

    @Query("FROM CredentialDbModel WHERE username = ?1 AND password = ?2")
    com.example.APICRUD30.repository. CredentialDbModel  findCredential(String username, String password);

}
