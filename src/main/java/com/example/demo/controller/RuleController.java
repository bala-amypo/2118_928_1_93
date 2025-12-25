package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.InteractionRule;
import com.example.demo.service.RuleService;

@RestController
@RequestMapping("/rules")
public class RuleController {

    private final RuleService service;

    public RuleController(RuleService service) {
        this.service = service;
    }

    @PostMapping
    public InteractionRule add(@RequestBody InteractionRule rule) {
        return service.addRule(rule);
    }

    @GetMapping
    public List<InteractionRule> all() {
        return service.getAllRules();
    }
}
