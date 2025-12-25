// CatalogServiceImpl.java
package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final ActiveIngredientRepository ir;
    private final MedicationRepository mr;

    public CatalogServiceImpl(ActiveIngredientRepository ir, MedicationRepository mr) {
        this.ir = ir;
        this.mr = mr;
    }

    public ActiveIngredient addIngredient(ActiveIngredient i) {
        return ir.save(i);
    }

    public Medication addMedication(Medication m) {
        return mr.save(m);
    }

    public List<Medication> getAllMedications() {
        return mr.findAll();
    }
}
