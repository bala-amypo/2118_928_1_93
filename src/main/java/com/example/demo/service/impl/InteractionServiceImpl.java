package com.example.demo.service.impl;

import com.example.demo.entity.InteractionCheckResult;
import com.example.demo.repository.InteractionCheckResultRepository;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final InteractionCheckResultRepository repository;

    public InteractionServiceImpl(InteractionCheckResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {

        InteractionCheckResult result = new InteractionCheckResult();
        result.setMedications(medicationIds.toString());
        result.setInteractions("No interaction logic implemented yet");
        result.setCheckedAt(LocalDateTime.now());

        return repository.save(result);
    }

    @Override
    public InteractionCheckResult getResultById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));
    }
}
