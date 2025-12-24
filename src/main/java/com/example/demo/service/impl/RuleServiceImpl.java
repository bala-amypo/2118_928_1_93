package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;

@Service
public class RuleServiceImpl implements RuleService {

    private final InteractionRuleRepository repo;

    public RuleServiceImpl(InteractionRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public InteractionRule saveRule(InteractionRule rule) {
        return repo.save(rule);
    }
}
