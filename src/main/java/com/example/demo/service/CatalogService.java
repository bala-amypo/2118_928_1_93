package com.example.demo.service;


import com.example.demo.model.*;
import java.util.List;


public interface CatalogService {
ActiveIngredient addIngredient(ActiveIngredient ingredient);
Medication addMedication(Medication medication);
List<Medication> getAllMedications();
}