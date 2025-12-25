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
    private ActiveIngredient ingredient1;

    @ManyToOne
    private ActiveIngredient ingredient2;

    private String severity;
    private String description;

    // ✅ REQUIRED BY TEST
    public InteractionRule(
            ActiveIngredient ingredient1,
            ActiveIngredient ingredient2,
            String severity,
            String description
    ) {
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.severity = severity;
        this.description = description;
    }
}
