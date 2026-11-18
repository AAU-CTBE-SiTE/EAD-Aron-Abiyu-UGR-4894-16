package com.site.ActorManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.site.ActorManagement.model.Actor;
import com.site.ActorManagement.service.ActorService;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService service;

    public ActorController(ActorService actorService) {
        this.service = actorService;
    }

    // Retrieve all actors
    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors() {
        return ResponseEntity.ok(service.getAllActors());
    }

    // Register a new actor
    @PostMapping
    public ResponseEntity<Actor> addActor(@RequestBody Actor actor) {

        Actor result = service.addActor(actor);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // Find an actor using ID
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable int id) {

        return service.getActorById(id)
                .map(actor -> ResponseEntity.ok(actor))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Modify existing actor information
    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(
            @PathVariable int id, @RequestBody Actor actor) {

        return service.updateActor(id, actor)
                .map(updated -> ResponseEntity.ok(updated))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Remove an actor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable int id) {

        if (!service.deleteActor(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
