package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class InteractionRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ingredient1_id")
    private Ingredient ingredient1;

    @ManyToOne
    @JoinColumn(name = "ingredient2_id")
    private Ingredient ingredient2;

    private String severity;
    private String description;

    // getters & setters
}
