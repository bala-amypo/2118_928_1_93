package com.example.demo.service.impl;

import com.example.demo.repository.InteractionCheckResultRepository;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;

@Service
public class InteractionServiceImpl implements InteractionService {

    public InteractionServiceImpl(InteractionCheckResultRepository r) {
    }
}
