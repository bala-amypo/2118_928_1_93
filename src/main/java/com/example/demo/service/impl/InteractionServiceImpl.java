package com.example.demo.service.impl;

import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    @Override
    public String checkInteractions(List<Long> medicationIds) {
        // temporary stub logic
        return "Interaction check completed";
    }

    @Override
    public String getResult(Long id) {
        return "Result for interaction id: " + id;
    }
}
