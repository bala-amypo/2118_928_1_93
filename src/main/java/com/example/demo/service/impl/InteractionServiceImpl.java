package com.example.demo.service.impl;

import com.example.demo.entity.Drug;
import com.example.demo.entity.Interaction;
import com.example.demo.repository.DrugRepository;
import com.example.demo.repository.InteractionRepository;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final DrugRepository drugRepository;
    private final InteractionRepository interactionRepository;

    public InteractionServiceImpl(DrugRepository drugRepository,
                                  InteractionRepository interactionRepository) {
        this.drugRepository = drugRepository;
        this.interactionRepository = interactionRepository;
    }

    @Override
    public String checkInteraction(String drug1, String drug2) {

        Drug d1 = drugRepository.findByName(drug1)
                .orElseThrow(() -> new RuntimeException("Drug not found: " + drug1));

        Drug d2 = drugRepository.findByName(drug2)
                .orElseThrow(() -> new RuntimeException("Drug not found: " + drug2));

        List<Interaction> interactions =
                interactionRepository.findByDrugAAndDrugB(d1, d2);

        if (interactions.isEmpty()) {
            return "No interaction found between " + drug1 + " and " + drug2;
        }

        return interactions.get(0).getDescription();
    }
}
