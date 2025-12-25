package com.example.demo.service;

import java.util.List;
import com.example.demo.model.InteractionRule;

public interface RuleService {
    InteractionRule addRule(InteractionRule rule);
    List<InteractionRule> getAllRules();
}
