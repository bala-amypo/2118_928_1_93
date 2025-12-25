package com.example.demo.service.impl;

import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RuleServiceImpl implements RuleService {

    private static final Set<String> ALLOWED_SEVERITY =
            Set.of("MINOR", "MODERATE", "MAJOR");

    private final InteractionRuleRepository ruleRepository;

    public RuleServiceImpl(InteractionRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public InteractionRule addRule(InteractionRule rule) {

        if (!ALLOWED_SEVERITY.contains(rule.getSeverity())) {
            throw new ValidationException("Invalid severity level");
        }

        Long a = rule.getIngredientA().getId();
        Long b = rule.getIngredientB().getId();

        ruleRepository.findRuleBetweenIngredients(a, b)
                .ifPresent(r -> {
                    throw new DuplicateResourceException("Interaction rule already exists");
                });

        return ruleRepository.save(rule);
    }

    @Override
    public List<InteractionRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
