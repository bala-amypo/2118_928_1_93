package com.example.demo.service.validation;

import com.example.demo.entity.InteractionRule;
import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public void validateRule(InteractionRule rule) {

        if (rule == null) {
            throw new BadRequestException("Interaction rule cannot be null");
        }

        if (rule.getIngredientA() == null || rule.getIngredientB() == null) {
            throw new BadRequestException("Both ingredients must be provided");
        }

        if (rule.getIngredientA().getId()
                .equals(rule.getIngredientB().getId())) {
            throw new BadRequestException(
                    "Ingredient A and Ingredient B cannot be the same");
        }

        if (rule.getSeverity() == null || rule.getSeverity().isBlank()) {
            throw new BadRequestException("Severity is required");
        }

        if (rule.getDescription() == null || rule.getDescription().isBlank()) {
            throw new BadRequestException("Description is required");
        }
    }
}
