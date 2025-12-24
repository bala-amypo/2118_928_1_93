package com.example.demo.controller;

import com.example.demo.model.InteractionRule;
import com.example.demo.service.RuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RuleController {

    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    // ADD RULE
    @PostMapping
    public InteractionRule addRule(@RequestBody InteractionRule rule) {
        return ruleService.addRule(rule);
    }

    // GET ALL RULES
    @GetMapping
    public List<InteractionRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
