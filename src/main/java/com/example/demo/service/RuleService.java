package com.example.demo.service;

import com.example.demo.entity.InteractionRule;
import java.util.List;

public interface RuleService {
    InteractionRule saveRule(InteractionRule rule);
    List<InteractionRule> getAllRules();
}
