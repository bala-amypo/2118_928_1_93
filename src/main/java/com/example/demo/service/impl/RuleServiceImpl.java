package com.example.demo.service.impl;

import com.example.demo.entity.InteractionRule;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    // temporary in-memory storage
    private final List<InteractionRule> rules = new ArrayList<>();

    @Override
    public InteractionRule addRule(InteractionRule rule) {
        // no validation now
        rules.add(rule);
        return rule;
    }

    @Override
    public List<InteractionRule> getAllRules() {
        return rules;
    }
}
