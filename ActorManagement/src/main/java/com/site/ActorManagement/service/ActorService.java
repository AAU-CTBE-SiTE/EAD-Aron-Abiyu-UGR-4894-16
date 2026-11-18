package com.site.ActorManagement.service;




import com.site.ActorManagement.model.Actor;
import com.site.ActorManagement.repo.ActorRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepo;

    // Constructor injection
    public ActorService(ActorRepository actorRepo) {
        this.actorRepo = actorRepo;
    }

    // CREATE
    public Actor addActor(Actor actor) {
        return actorRepo.save(actor);
    }

    // READ ALL
    public List<Actor> getAllActors() {
        return actorRepo.findAll();
    }

    // READ BY ID
    public Optional<Actor> getActorById(int id) {
        return actorRepo.findById(id);
    }

    // UPDATE
    public Optional<Actor> updateActor(int id, Actor updatedActor) {

        return actorRepo.findById(id).map(actor -> {

            actor.setName(updatedActor.getName());
            actor.setMovieName(updatedActor.getMovieName());

            return actorRepo.save(actor);
        });
    }

    // DELETE
    public boolean deleteActor(int id) {

        if (actorRepo.existsById(id)) {
            actorRepo.deleteById(id);
            return true;
        }

        return false;
    }
}

