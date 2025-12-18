package com.example.demo.service.impl;

import com.example.demo.entity.InteractionCheckResult;
import com.example.demo.repository.InteractionCheckResultRepository;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final InteractionCheckResultRepository repository;

    public InteractionServiceImpl(InteractionCheckResultRepository r) {
        this.repository = r;
    }

    @Override
    public InteractionCheckResult checkInteractions(List<Long> ids) {
        // Simple dummy logic; replace with real interaction check
        InteractionCheckResult result = new InteractionCheckResult();
        result.setResult("Checked " + ids.size() + " items");
        return repository.save(result);
    }

    @Override
    public InteractionCheckResult getResult(Long id) {
        return repository.findById(id).orElse(null);
    }
}
