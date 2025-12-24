package com.example.demo.service;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.Medication;
import java.util.List;

public interface CatalogService {

    void addIngredient(ActiveIngredient ingredient);

    void addMedication(Medication medication);

    List<Medication> getAllMedications();
}
