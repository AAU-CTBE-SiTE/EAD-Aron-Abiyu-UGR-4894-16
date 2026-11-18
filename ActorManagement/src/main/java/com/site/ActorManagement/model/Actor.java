package com.site.ActorManagement.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "actors")
public class Actor {

    private String movieName;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Actor() {
        // Default constructor
    }

    public Actor(String name, String movieName) {
        setMovieName(movieName);
        setName(name);
    }
}
