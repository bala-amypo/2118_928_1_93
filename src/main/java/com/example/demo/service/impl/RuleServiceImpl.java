package com.example.demo.service.impl;

import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements RuleService {

    public RuleServiceImpl(InteractionRuleRepository r) {
    }
}
