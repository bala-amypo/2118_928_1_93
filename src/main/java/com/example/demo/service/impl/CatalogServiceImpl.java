package com.example.demo.service.impl;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.Medication;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final List<ActiveIngredient> ingredients = new ArrayList<>();
    private final List<Medication> medications = new ArrayList<>();

    @Override
    public void addIngredient(ActiveIngredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    @Override
    public List<Medication> getAllMedications() {
        return medications;
    }
}
