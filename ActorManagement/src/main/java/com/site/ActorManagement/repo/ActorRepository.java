package com.site.ActorManagement.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.site.ActorManagement.model.Actor;

public interface ActorRepository
        extends JpaRepository<Actor, Integer> {

    // Inherits CRUD operations from JpaRepository

}
