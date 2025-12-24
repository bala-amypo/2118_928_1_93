package com.example.demo.service.impl;

import com.example.demo.model.InteractionCheckResult;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {
        // minimal dummy implementation
        return new InteractionCheckResult();
    }

    @Override
    public InteractionCheckResult getResult(Long id) {
        return new InteractionCheckResult();
    }
}
