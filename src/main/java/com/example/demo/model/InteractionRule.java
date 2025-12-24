package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class InteractionRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActiveIngredient ingredient1;

    @ManyToOne
    private ActiveIngredient ingredient2;

    private String severity;
    private String description;

    // ✅ REQUIRED by tests
    public InteractionRule() {
    }

    // ✅ REQUIRED by tests
    public InteractionRule(
            ActiveIngredient ingredientA,
            ActiveIngredient ingredientB,
            String severity,
            String description) {

        this.ingredient1 = ingredientA;
        this.ingredient2 = ingredientB;
        this.severity = severity;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // 🔥 TEST EXPECTS ingredientA / ingredientB NAMES
    public ActiveIngredient getIngredientA() {
        return ingredient1;
    }

    public void setIngredientA(ActiveIngredient ingredientA) {
        this.ingredient1 = ingredientA;
    }

    public ActiveIngredient getIngredientB() {
        return ingredient2;
    }

    public void setIngredientB(ActiveIngredient ingredientB) {
        this.ingredient2 = ingredientB;
    }

    // existing getters/setters still ok
    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
