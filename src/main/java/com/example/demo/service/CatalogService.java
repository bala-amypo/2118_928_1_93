// CatalogService.java
package com.example.demo.service;
import java.util.List;
import com.example.demo.model.*;

public interface CatalogService {
    ActiveIngredient addIngredient(ActiveIngredient i);
    Medication addMedication(Medication m);
    List<Medication> getAllMedications();
}
