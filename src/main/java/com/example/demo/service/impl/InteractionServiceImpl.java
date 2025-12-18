package com.example.demo.service.impl;

import com.example.demo.entity.InteractionCheckResult;
import com.example.demo.repository.InteractionCheckResultRepository;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final InteractionCheckResultRepository resultRepository;

    public InteractionServiceImpl(InteractionCheckResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {

        InteractionCheckResult result = new InteractionCheckResult();
        result.setMedications(medicationIds.toString());
        result.setInteractions("[]");
        result.setCheckedAt(LocalDateTime.now());

        return resultRepository.save(result);
    }

    @Override
    public InteractionCheckResult getResult(Long resultId) {
        return resultRepository.findById(resultId).orElse(null);
    }
}
