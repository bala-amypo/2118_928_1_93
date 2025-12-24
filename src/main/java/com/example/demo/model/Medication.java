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


private String name;


@ManyToMany
@JoinTable(
name = "medication_ingredients",
joinColumns = @JoinColumn(name = "medication_id"),
inverseJoinColumns = @JoinColumn(name = "ingredient_id")
)
private Set<ActiveIngredient> ingredients = new HashSet<>();


public Medication() {}


public Medication(String name) {
this.name = name;
}


public void addIngredient(ActiveIngredient ingredient) {
ingredients.add(ingredient);
}


// getters and setters
}