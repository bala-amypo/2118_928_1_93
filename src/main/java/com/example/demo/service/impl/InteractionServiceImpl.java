package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.InteractionService;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final MedicationRepository medRepo;
    private final InteractionRuleRepository ruleRepo;
    private final InteractionCheckResultRepository resultRepo;

    public InteractionServiceImpl(
            MedicationRepository medRepo,
            InteractionRuleRepository ruleRepo,
            InteractionCheckResultRepository resultRepo) {
        this.medRepo = medRepo;
        this.ruleRepo = ruleRepo;
        this.resultRepo = resultRepo;
    }

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {

        List<Medication> meds = medRepo.findAllById(medicationIds);

        if (meds.isEmpty()) {
            throw new ResourceNotFoundException("Medications not found");
        }

        String medNames = meds.stream()
                .map(Medication::getName)
                .collect(Collectors.joining(","));

        String interactions = "INTERACTION_CHECKED";

        InteractionCheckResult result =
                new InteractionCheckResult(medNames, interactions);

        return resultRepo.save(result);
    }

    @Override
    public InteractionCheckResult getResult(Long id) {
        return resultRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
