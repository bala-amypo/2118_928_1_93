package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private Set<ActiveIngredient> activeIngredients = new HashSet<>();

    // ✅ REQUIRED BY TEST
    public Medication(String name) {
        this.name = name;
    }

    // ✅ REQUIRED METHODS
    public void addIngredient(ActiveIngredient ingredient) {
        activeIngredients.add(ingredient);
    }

    public void removeIngredient(ActiveIngredient ingredient) {
        activeIngredients.remove(ingredient);
    }
}
