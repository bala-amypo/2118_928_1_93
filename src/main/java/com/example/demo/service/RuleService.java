package com.example.demo.service;

import com.example.demo.model.InteractionRule;

public interface RuleService {

    InteractionRule addRule(InteractionRule rule);

    // ✅ REQUIRED by controller
    InteractionRule saveRule(InteractionRule rule);
}
