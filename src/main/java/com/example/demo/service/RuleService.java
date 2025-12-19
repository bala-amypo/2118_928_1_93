package com.example.demo.service;

public interface RuleService {

    void createRule(
            Long ingredientAId,
            Long ingredientBId,
            String severity,
            String description
    );
}
