package com.example.demo.service;

import com.example.demo.model.InteractionRule;
import java.util.List;

public interface RuleService {

    void addRule(InteractionRule rule);

    List<InteractionRule> getAllRules();
}
