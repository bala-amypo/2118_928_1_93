package com.example.demo.service.impl;

import com.example.demo.entity.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import com.example.demo.service.validation.ValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    private final InteractionRuleRepository ruleRepository;
    private final ValidationService validationService;

    public RuleServiceImpl(InteractionRuleRepository ruleRepository,
                           ValidationService validationService) {
        this.ruleRepository = ruleRepository;
        this.validationService = validationService;
    }

    @Override
    public InteractionRule addRule(InteractionRule rule) {
        validationService.validateRule(rule);
        return ruleRepository.save(rule);
    }

    @Override
    public List<InteractionRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
