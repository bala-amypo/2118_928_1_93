package com.example.demo.service.impl;

import com.example.demo.entity.InteractionRule;
import com.example.demo.service.RuleService;
import com.example.demo.service.Validation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    private final Validation validation;

    // temporary in-memory storage
    private final List<InteractionRule> rules = new ArrayList<>();

    public RuleServiceImpl(Validation validation) {
        this.validation = validation;
    }

    @Override
    public InteractionRule addRule(InteractionRule rule) {

        validation.validateRule(rule);

        rules.add(rule);
        return rule;
    }

    @Override
    public List<InteractionRule> getAllRules() {
        return rules;
    }
}
