package com.example.demo.controller;

import com.example.demo.model.Actor;
import com.example.demo.model.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
@RequiredArgsConstructor
public class ActorController {

    private final ActorRepository repository;

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Actor>> fetchActors() {
        List<Actor> actors = repository.findAll();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Actor> fetchActor(@PathVariable Long id) {
        if (repository.existsById(id)) {
            Actor actor = repository.findById(id).get();
            return ResponseEntity.ok(actor);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Actor> addActor(@RequestBody Actor newActor) {
        Actor result = repository.save(newActor);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // PARTIAL UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<Actor> modifyActor(
            @PathVariable Long id,
            @RequestBody Actor changes) {

        Actor current = repository.findById(id).orElse(null);

        if (current == null) {
            return ResponseEntity.notFound().build();
        }

        String movie = changes.getMovieName();
        String name = changes.getActorName();

        if (movie != null) {
            current.setMovieName(movie);
        }

        if (name != null) {
            current.setActorName(name);
        }

        Actor saved = repository.save(current);
        return ResponseEntity.ok(saved);
    }

    // FULL UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Actor> replaceActor(
            @PathVariable Long id,
            @RequestBody Actor replacement) {

        Actor current = repository.findById(id).orElse(null);

        if (current == null) {
            return ResponseEntity.notFound().build();
        }

        current.setActorName(replacement.getActorName());
        current.setMovieName(replacement.getMovieName());

        return ResponseEntity.ok(repository.save(current));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeActor(@PathVariable Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
