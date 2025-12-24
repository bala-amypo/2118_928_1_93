package com.example.demo.controller;

import com.example.demo.model.InteractionRule;
import com.example.demo.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @PostMapping("/add")
    public void addRule(@RequestBody InteractionRule rule) {
        // Fixed: call void method, no assignment
        ruleService.addRule(rule);
    }

    @GetMapping("/all")
    public List<InteractionRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
