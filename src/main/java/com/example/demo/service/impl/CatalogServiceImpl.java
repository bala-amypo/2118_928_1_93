package com.example.demo.service.impl;


import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CatalogServiceImpl implements CatalogService {


private final ActiveIngredientRepository ingredientRepo;
private final MedicationRepository medicationRepo;


public CatalogServiceImpl(ActiveIngredientRepository i, MedicationRepository m) {
this.ingredientRepo = i;
this.medicationRepo = m;
}


public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
if (ingredientRepo.existsByName(ingredient.getName()))
throw new IllegalArgumentException("Ingredient already exists");
return ingredientRepo.save(ingredient);
}


public Medication addMedication(Medication medication) {
if (medication.getIngredients().isEmpty())
throw new IllegalArgumentException("Medication must have at least one ingredient");
return medicationRepo.save(medication);
}


public List<Medication> getAllMedications() {
return medicationRepo.findAll();
}
}