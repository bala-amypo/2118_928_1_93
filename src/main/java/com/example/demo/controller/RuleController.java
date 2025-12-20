package com.example.demo.controller;

import com.example.demo.entity.InteractionRule;
import com.example.demo.service.RuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RuleController {

    private final RuleService service;

    public RuleController(RuleService service) {
        this.service = service;
    }

    @PostMapping
    public InteractionRule create(@RequestBody InteractionRule rule) {
        return service.saveRule(rule);
    }

    @GetMapping
    public List<InteractionRule> getAll() {
        return service.getAllRules();
    }
}
