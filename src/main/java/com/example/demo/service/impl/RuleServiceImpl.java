package com.example.demo.service.impl;


import com.example.demo.model.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class RuleServiceImpl implements RuleService {


private final InteractionRuleRepository repo;


public RuleServiceImpl(InteractionRuleRepository repo) {
this.repo = repo;
}


public InteractionRule addRule(InteractionRule rule) {
List<String> valid = List.of("MINOR", "MODERATE", "MAJOR");
if (!valid.contains(rule.getSeverity()))
throw new IllegalArgumentException("Invalid severity");


repo.findRuleBetweenIngredients(
rule.getIngredientA().getId(),
rule.getIngredientB().getId()
).ifPresent(r -> { throw new IllegalArgumentException("Rule already exists"); });


return repo.save(rule);
}


public List<InteractionRule> getAllRules() {
return repo.findAll();
}
}