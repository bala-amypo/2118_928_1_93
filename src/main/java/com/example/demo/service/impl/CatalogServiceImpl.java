package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final ActiveIngredientRepository ingredientRepo;
    private final MedicationRepository medicationRepo;

    public CatalogServiceImpl(ActiveIngredientRepository ingredientRepo,
                              MedicationRepository medicationRepo) {
        this.ingredientRepo = ingredientRepo;
        this.medicationRepo = medicationRepo;
    }

    public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
        return ingredientRepo.save(ingredient);
    }

    public Medication addMedication(Medication medication) {
        return medicationRepo.save(medication);
    }

    public List<Medication> getAllMedications() {
        return medicationRepo.findAll();
    }
}