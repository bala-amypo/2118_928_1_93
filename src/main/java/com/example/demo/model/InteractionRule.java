package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
