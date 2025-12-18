package com.example.demo.service;
import com.example.demo.entity.ActiveIntegredient;
import com.example.demo.entity.Medication;
import java.util.List;
public interface CatalogService{
    ActiveIngredient addIntegredient(ActiveIngredient ingredient);
    Medication addMedication(Medication medication);
    List<Medication>getAllMedication();
}