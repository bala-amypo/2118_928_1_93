package com.example.demo.service.impl;

import com.example.demo.entity.InteractionCheckResult;
import com.example.demo.repository.InteractionCheckResultRepository;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final InteractionCheckResultRepository repository;

    public InteractionServiceImpl(InteractionCheckResultRepository repository) {
        this.repository = repository;
    }

    public InteractionCheckResult saveResult(InteractionCheckResult result) {
        return repository.save(result);
    }
}