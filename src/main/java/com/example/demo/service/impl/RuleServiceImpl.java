package com.example.demo.service.impl;

import com.example.demo.model.InteractionRule;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    private final List<InteractionRule> rules = new ArrayList<>();

    @Override
    public void addRule(InteractionRule rule) {
        rules.add(rule);
    }

    @Override
    public List<InteractionRule> getAllRules() {
        return rules;
    }
}
