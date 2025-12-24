package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ActiveIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // REQUIRED
    public ActiveIngredient() {
    }

    // REQUIRED by TEST
    public ActiveIngredient(String name) {
        this.name = name;
    }

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
