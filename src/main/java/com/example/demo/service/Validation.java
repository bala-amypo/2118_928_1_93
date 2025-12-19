package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class Validation {

    public void validateRule(
            Long ingredientAId,
            Long ingredientBId,
            String severity,
            String description
    ) {

        if (ingredientAId == null) {
            throw new BadRequestException("IngredientA id is required");
        }

        if (ingredientBId == null) {
            throw new BadRequestException("IngredientB id is required");
        }

        if (ingredientAId.equals(ingredientBId)) {
            throw new BadRequestException("IngredientA and IngredientB cannot be same");
        }

        if (severity == null || severity.trim().isEmpty()) {
            throw new BadRequestException("Severity is required");
        }

        if (description == null || description.trim().isEmpty()) {
            throw new BadRequestException("Description is required");
        }
    }
}
