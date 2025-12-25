package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "interaction_rules")
public class InteractionRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActiveIngredient ingredientA;

    @ManyToOne
    private ActiveIngredient ingredientB;

    private String severity;
    private String description;

    public InteractionRule() {}

    public InteractionRule(ActiveIngredient a, ActiveIngredient b, String s, String d) {
        this.ingredientA = a;
        this.ingredientB = b;
        this.severity = s;
        this.description = d;
    }

    public Long getId() { return id; }
    public ActiveIngredient getIngredientA() { return ingredientA; }
    public ActiveIngredient getIngredientB() { return ingredientB; }
    public String getSeverity() { return severity; }
    public String getDescription() { return description; }
}
