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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ActiveIngredient getIngredient1() {
        return ingredient1;
    }

    public void setIngredient1(ActiveIngredient ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public ActiveIngredient getIngredient2() {
        return ingredient2;
    }

    public void setIngredient2(ActiveIngredient ingredient2) {
        this.ingredient2 = ingredient2;
    }

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
