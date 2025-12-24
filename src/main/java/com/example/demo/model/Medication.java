package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<ActiveIngredient> ingredients = new ArrayList<>();

    // REQUIRED
    public Medication() {
    }

    // REQUIRED by TEST
    public Medication(String name) {
        this.name = name;
    }

    // ===== TEST EXPECTED METHODS =====
    public void addIngredient(ActiveIngredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public String getName() {
        return name;
    }

    public List<ActiveIngredient> getIngredients() {
        return ingredients;
    }
}
