package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.InteractionRule;
import com.example.demo.service.RuleService;

@RestController
@RequestMapping("/rules")
public class RuleController {

    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public InteractionRule saveRule(@RequestBody InteractionRule rule) {
        return ruleService.saveRule(rule);
    }
}
