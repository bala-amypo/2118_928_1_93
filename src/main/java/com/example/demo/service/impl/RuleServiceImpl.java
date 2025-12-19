package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.service.RuleService;
import com.example.demo.service.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private Validation validation;

    @Override
    public void createRule(
            Long ingredientAId,
            Long ingredientBId,
            String severity,
            String description
    ) {

        // 🔒 validation
        validation.validateRule(
                ingredientAId,
                ingredientBId,
                severity,
                description
        );

        // 👉 temporary logic (since no entity/repo in your structure)
        // later you can add DB save here

        if ("high".equalsIgnoreCase(severity)) {
            // example business rule
            System.out.println("High severity rule created");
        }
    }
}
