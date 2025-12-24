package com.example.demo.service.impl;

import com.example.demo.model.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements RuleService {

    private final InteractionRuleRepository repository;

    public RuleServiceImpl(InteractionRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public InteractionRule addRule(InteractionRule rule) {
        return repository.save(rule);
    }
}
