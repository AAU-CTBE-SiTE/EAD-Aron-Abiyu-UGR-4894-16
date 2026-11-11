package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "actors")
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

    private String actorName;

    private String movieName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
