package com.example.demo.service.impl;

import com.example.demo.model.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {
    private final InteractionRuleRepository ruleRepository;
    
    public RuleServiceImpl(InteractionRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }
    
    @Override
    public InteractionRule addRule(InteractionRule rule) {
        List<String> validSeverities = Arrays.asList("MINOR", "MODERATE", "MAJOR");
        if (!validSeverities.contains(rule.getSeverity())) {
            throw new IllegalArgumentException("Invalid severity");
        }
        
        if (ruleRepository.findRuleBetweenIngredients(
                rule.getIngredientA().getId(), 
                rule.getIngredientB().getId()).isPresent()) {
            throw new IllegalArgumentException("Rule already exists for this ingredient pair");
        }
        
        return ruleRepository.save(rule);
    }
    
    @Override
    public List<InteractionRule> getAllRules() {
        return ruleRepository.findAll();
    }
}