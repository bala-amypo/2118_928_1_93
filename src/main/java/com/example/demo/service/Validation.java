package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.entity.Rule;
import org.springframework.stereotype.Component;

@Component
public class Validation {

    public void ValidateRule(Rule rule) {

        if (rule == null) {
            throw new BadRequestException("Rule object cannot be null");
        }

        if (rule.getIngredientA() == null) {
            throw new BadRequestException("IngredientA is required");
        }

        if (rule.getIngredientB() == null) {
            throw new BadRequestException("IngredientB is required");
        }

        if (rule.getIngredientA().getId()
                .equals(rule.getIngredientB().getId())) {
            throw new BadRequestException("IngredientA and IngredientB cannot be same");
        }

        if (rule.getSeverity() == null || rule.getSeverity().isBlank()) {
            throw new BadRequestException("Severity is required");
        }

        if (rule.getDescription() == null || rule.getDescription().isBlank()) {
            throw new BadRequestException("Description is required");
        }
    }
}
