package com.example.demo.service.impl;

import com.example.demo.entity.ActiveIngredient;
import com.example.demo.entity.InteractionRule;
import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    private final InteractionRuleRepository ruleRepository;
    private final ActiveIngredientRepository ingredientRepository;

    public RuleServiceImpl(InteractionRuleRepository ruleRepository,
                           ActiveIngredientRepository ingredientRepository) {
        this.ruleRepository = ruleRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public InteractionRule saveRule(InteractionRule rule) {

        ActiveIngredient a = ingredientRepository
                .findById(rule.getIngredientA().getId())
                .orElseThrow(() -> new RuntimeException("Ingredient A not found"));

        ActiveIngredient b = ingredientRepository
                .findById(rule.getIngredientB().getId())
                .orElseThrow(() -> new RuntimeException("Ingredient B not found"));

        rule.setIngredientA(a);
        rule.setIngredientB(b);

        return ruleRepository.save(rule);
    }

    @Override
    public List<InteractionRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
