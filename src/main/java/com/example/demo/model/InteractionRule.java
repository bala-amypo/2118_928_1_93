package com.example.demo.model;


import jakarta.persistence.*;


@Entity
@Table(name = "interaction_rules",
uniqueConstraints = @UniqueConstraint(columnNames = {"ingredient_a_id", "ingredient_b_id"}))
public class InteractionRule {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne(optional = false)
@JoinColumn(name = "ingredient_a_id")
private ActiveIngredient ingredientA;


@ManyToOne(optional = false)
@JoinColumn(name = "ingredient_b_id")
private ActiveIngredient ingredientB;


@Column(nullable = false)
private String severity;


@Column(length = 1000)
private String description;


public InteractionRule() {
}


public InteractionRule(ActiveIngredient ingredientA, ActiveIngredient ingredientB, String severity, String description) {
this.ingredientA = ingredientA;
this.ingredientB = ingredientB;
this.severity = severity;
this.description = description;
}


// getters and setters
}