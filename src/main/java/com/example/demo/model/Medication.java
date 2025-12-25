package com.example.demo.model;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "medications")
public class Medication {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false)
private String name;


@ManyToMany
@JoinTable(
name = "medication_ingredients",
joinColumns = @JoinColumn(name = "medication_id"),
inverseJoinColumns = @JoinColumn(name = "ingredient_id")
)
private Set<ActiveIngredient> ingredients = new HashSet<>();


public Medication() {
}


public Medication(String name) {
this.name = name;
this.ingredients = new HashSet<>();
}


public void addIngredient(ActiveIngredient ingredient) {
this.ingredients.add(ingredient);
}


public void removeIngredient(ActiveIngredient ingredient) {
this.ingredients.remove(ingredient);
}


// getters and setters
}