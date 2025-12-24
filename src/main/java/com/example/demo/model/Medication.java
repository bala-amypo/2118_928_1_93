package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<ActiveIngredient> ingredients;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ActiveIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<ActiveIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
