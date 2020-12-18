package com.example.demo.Repository;

import com.example.demo.MOdelsDb.PersonDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonDB,Long> {
    @Query("FROM PersonDB WHERE edad=?1")
    List<PersonDB> findpeopleage(int age );


}
