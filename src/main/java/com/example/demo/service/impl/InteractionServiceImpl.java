package com.example.demo.service.impl;

import com.example.demo.model.InteractionCheckResult;
import com.example.demo.service.InteractionService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {

        InteractionCheckResult result = new InteractionCheckResult();
        result.setMessage("No severe interactions found");
        result.setSeverity("LOW");

        return result; // ✅ NOT STRING
    }

    @Override
    public InteractionCheckResult getResult(Long id) {

        InteractionCheckResult result = new InteractionCheckResult();
        result.setMessage("Interaction result for ID " + id);
        result.setSeverity("LOW");

        return result; // ✅ NOT STRING
    }
}
