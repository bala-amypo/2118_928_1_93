package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
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

    public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
        return ingredientRepo.save(ingredient);
    }

    public Medication addMedication(Medication medication) {

        // 🔥 IMPORTANT PART
        Set<ActiveIngredient> managedIngredients = new HashSet<>();

        for (ActiveIngredient ing : medication.getIngredients()) {
            ActiveIngredient dbIngredient =
                    ingredientRepo.findById(ing.getId())
                    .orElseThrow(() -> new RuntimeException(
                        "Ingredient not found with id: " + ing.getId()
                    ));

            managedIngredients.add(dbIngredient);
        }

        medication.setIngredients(managedIngredients);

        return medicationRepo.save(medication);
    }

    public List<Medication> getAllMedications() {
        return medicationRepo.findAll();
    }
}
