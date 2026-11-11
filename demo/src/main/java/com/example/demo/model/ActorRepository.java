package com.example.demo.model;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ActorRepository
        extends JpaRepository<Actor, Long> {

}
