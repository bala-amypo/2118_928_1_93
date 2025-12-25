package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.InteractionCheckResultRepository;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final MedicationRepository medicationRepository;
    private final InteractionRuleRepository ruleRepository;
    private final InteractionCheckResultRepository resultRepository;

    public InteractionServiceImpl(MedicationRepository medicationRepository,
                                  InteractionRuleRepository ruleRepository,
                                  InteractionCheckResultRepository resultRepository) {
        this.medicationRepository = medicationRepository;
        this.ruleRepository = ruleRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {

        List<Medication> medications = medicationRepository.findAllById(medicationIds);

        Set<ActiveIngredient> ingredients = medications.stream()
                .flatMap(m -> m.getIngredients().stream())
                .collect(Collectors.toSet());

        List<InteractionRule> rules = ruleRepository.findAll();

        List<String> found = new ArrayList<>();

        for (InteractionRule rule : rules) {
            if (ingredients.contains(rule.getIngredientA()) &&
                ingredients.contains(rule.getIngredientB())) {
                found.add(rule.getDescription());
            }
        }

        String meds = medications.stream()
                .map(Medication::getName)
                .collect(Collectors.joining(","));

        String json = "{ \"count\": " + found.size() +
                ", \"details\": " + found.toString() + " }";

        InteractionCheckResult result =
                new InteractionCheckResult(meds, json);

        return resultRepository.save(result);
    }

    @Override
    public InteractionCheckResult getResult(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
