package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private Set<ActiveIngredient> ingredients = new HashSet<>();

    public Medication() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ✅ FIX for test typo: setSetName()
    public void setSetName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ActiveIngredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(ActiveIngredient ingredient) {
        ingredients.add(ingredient);
    }

    // ✅ REQUIRED by tests
    public void removeIngredient(ActiveIngredient ingredient) {
        ingredients.remove(ingredient);
    }
}
