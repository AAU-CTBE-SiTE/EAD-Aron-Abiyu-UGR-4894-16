package com.site.actor_management.controller;

import com.site.actor_management.model.Actor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    @PersistenceContext
    private EntityManager manager;

    // CREATE
    @PostMapping
    @Transactional
    public ResponseEntity<Actor> saveActor(@RequestBody Actor actor) {

        manager.persist(actor);

        return ResponseEntity.ok().body(actor);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Actor>> listActors() {

        List<Actor> actorList = manager
                .createQuery("SELECT actor FROM Actor actor", Actor.class)
                .getResultList();

        return ResponseEntity.ok().body(actorList);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Actor> searchActor(@PathVariable("id") Long actorId) {

        Actor foundActor = manager.find(Actor.class, actorId);

        if (foundActor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(foundActor);
    }

    // FULL UPDATE
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Actor> replaceActor(
            @PathVariable("id") Long actorId,
            @RequestBody Actor actorDetails) {

        Actor currentActor = manager.find(Actor.class, actorId);

        if (currentActor == null) {
            return ResponseEntity.notFound().build();
        }

        currentActor.setActorName(actorDetails.getActorName());
        currentActor.setMovieName(actorDetails.getMovieName());

        return ResponseEntity.ok().body(currentActor);
    }

    // PARTIAL UPDATE
    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<Actor> updateActorFields(
            @PathVariable("id") Long actorId,
            @RequestBody Map<String, Object> fields) {

        Actor currentActor = manager.find(Actor.class, actorId);

        if (currentActor == null) {
            return ResponseEntity.notFound().build();
        }

        fields.forEach((key, value) -> {
            switch (key) {
                case "actorName" ->
                        currentActor.setActorName((String) value);

                case "movieName" ->
                        currentActor.setMovieName((String) value);
            }
        });

        return ResponseEntity.ok().body(currentActor);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> removeActor(@PathVariable("id") Long actorId) {

        Actor selectedActor = manager.find(Actor.class, actorId);

        if (selectedActor == null) {
            return ResponseEntity.notFound().build();
        }

        manager.remove(selectedActor);

        return ResponseEntity.noContent().build();
    }
}
