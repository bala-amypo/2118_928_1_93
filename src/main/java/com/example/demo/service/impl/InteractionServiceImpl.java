package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.InteractionCheckResultRepository;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.InteractionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.*;

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

        List<Medication> medications =
                medicationRepository.findAllById(medicationIds);

        Set<ActiveIngredient> ingredients = new HashSet<>();
        for (Medication med : medications) {
            ingredients.addAll(med.getIngredients());
        }

        List<InteractionRule> foundRules = new ArrayList<>();
        for (ActiveIngredient ingredient : ingredients) {
            foundRules.addAll(
                    ruleRepository.findByIngredientId(ingredient.getId())
            );
        }

        Map<String, Object> summary = new HashMap<>();
        summary.put("interactionCount", foundRules.size());
        summary.put("details", foundRules);

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(summary);

            String medNames = medications.stream()
                    .map(Medication::getName)
                    .reduce((a, b) -> a + \", \" + b)
                    .orElse(\"\");

            InteractionCheckResult result =
                    new InteractionCheckResult(medNames, json);

            return resultRepository.save(result);

        } catch (Exception e) {
            throw new RuntimeException(\"Failed to build interaction summary\");
        }
    }

    @Override
    public InteractionCheckResult getResult(Long resultId) {
        return resultRepository.findById(resultId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(\"Result not found\"));
    }
}
