package com.example.demo.service.impl;

import com.example.demo.entity.ActiveIngredient;
import com.example.demo.entity.Medication;
import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.CatalogService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final MedicationRepository medicationRepository;
    private final ActiveIngredientRepository activeIngredientRepository;

    public CatalogServiceImpl(MedicationRepository medicationRepository,
                              ActiveIngredientRepository activeIngredientRepository) {
        this.medicationRepository = medicationRepository;
        this.activeIngredientRepository = activeIngredientRepository;
    }

    @Override
    public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
        return activeIngredientRepository.save(ingredient);
    }

    @Transactional
    @Override
    public Medication addMedication(Medication medication) {

        Set<ActiveIngredient> managedIngredients = new HashSet<>();

        for (ActiveIngredient ing : medication.getIngredients()) {
            ActiveIngredient dbIng =
                    activeIngredientRepository.findById(ing.getId())
                            .orElseThrow(() -> new RuntimeException("Ingredient not found"));
            managedIngredients.add(dbIng);
        }

        medication.setIngredients(managedIngredients);
        return medicationRepository.save(medication);
    }

    @Override
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }
}
