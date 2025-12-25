package com.example.demo.service.impl;

import com.example.demo.model.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {
    
    private InteractionRuleRepository ruleRepository;
    
    public RuleServiceImpl() {
        this.ruleRepository = null;
    }
    
    public RuleServiceImpl(InteractionRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }
    
    @Override
    public InteractionRule addRule(InteractionRule rule) {
        if (ruleRepository.findRuleBetweenIngredients(
                rule.getIngredientA().getId(), 
                rule.getIngredientB().getId()).isPresent()) {
            throw new IllegalArgumentException("Rule already exists for this ingredient pair");
        }
        
        if (!List.of("MINOR", "MODERATE", "MAJOR").contains(rule.getSeverity())) {
            throw new IllegalArgumentException("Severity must be MINOR, MODERATE, or MAJOR");
        }
        
        return ruleRepository.save(rule);
    }
    
    @Override
    public List<InteractionRule> getAllRules() {
        return ruleRepository.findAll();
    }
}