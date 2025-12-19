package com.example.demo.service.impl;

import com.example.demo.entity.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    private final InteractionRuleRepository repository;

    public RuleServiceImpl(InteractionRuleRepository repository) {
        this.repository = repository;
    }

    public InteractionRule addRule(InteractionRule rule) {
        return repository.save(rule);
    }

    public List<InteractionRule> getAllRules() {
        return repository.findAll();
    }
}