package com.example.demo.service.impl;

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

        validation.validateRule(
                ingredientAId,
                ingredientBId,
                severity,
                description
        );

        // DB save logic later
        System.out.println("Rule validated successfully");
    }
}
