package com.example.demo.service.impl;

import com.example.demo.model.Interaction;
import com.example.demo.repository.InteractionRepository;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final InteractionRepository interactionRepository;

    public InteractionServiceImpl(InteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }

    @Override
    public Interaction addInteraction(Interaction interaction) {
        return interactionRepository.save(interaction);
    }

    @Override
    public List<Interaction> getAllInteractions() {
        return interactionRepository.findAll();
    }
}
