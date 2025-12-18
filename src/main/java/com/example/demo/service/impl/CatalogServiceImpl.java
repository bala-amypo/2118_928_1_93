package com.example.demo.service.impl;

import com.example.demo.entity.ActiveIngredient;
import com.example.demo.entity.Medication;
import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.repository.MedicationRepository;
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

    @Override
    public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
        return ingredientRepo.save(ingredient);
    }

    @Override
    public Medication addMedication(Medication medication) {
        return medicationRepo.save(medication);
    }

    @Override
    public List<Medication> getAllMedications() {
        return medicationRepo.findAll();
    }
}
