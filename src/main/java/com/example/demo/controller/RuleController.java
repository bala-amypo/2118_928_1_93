package com.example.demo.controller;

import com.example.demo.model.InteractionRule;
import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.service.RuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rules")
@Tag(name = "Rules", description = "Interaction rules endpoints")
public class RuleController {
    private final RuleService ruleService;
    private final ActiveIngredientRepository ingredientRepository;
    
    public RuleController(RuleService ruleService, ActiveIngredientRepository ingredientRepository) {
        this.ruleService = ruleService;
        this.ingredientRepository = ingredientRepository;
    }
    
    @PostMapping
    public ResponseEntity<InteractionRule> addRule(@RequestBody Map<String, Object> request) {
        Long ingredientAId = Long.valueOf(request.get("ingredientAId").toString());
        Long ingredientBId = Long.valueOf(request.get("ingredientBId").toString());
        String severity = (String) request.get("severity");
        String description = (String) request.get("description");
        
        InteractionRule rule = new InteractionRule(
                ingredientRepository.findById(ingredientAId).orElseThrow(),
                ingredientRepository.findById(ingredientBId).orElseThrow(),
                severity,
                description
        );
        
        return ResponseEntity.ok(ruleService.addRule(rule));
    }
    
    @GetMapping
    public ResponseEntity<List<InteractionRule>> getAllRules() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }
}