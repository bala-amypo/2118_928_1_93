package com.example.demo.service.impl;

import com.example.demo.entity.ActiveIngredient;
import com.example.demo.entity.Medication;
import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        Set<ActiveIngredient> resolvedIngredients = new HashSet<>();

        for (ActiveIngredient ing : medication.getIngredients()) {
            ActiveIngredient dbIngredient = ingredientRepo
                    .findById(ing.getId())
                    .orElseThrow(() ->
                        new RuntimeException("Ingredient not found with id: " + ing.getId())
                    );

            resolvedIngredients.add(dbIngredient);
        }

        medication.setIngredients(resolvedIngredients);

        return medicationRepo.save(medication);
    }

    @Override
    public List<Medication> getAllMedications() {
        return medicationRepo.findAll();
    }
}
