package com.example.demo.service.impl;

import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.repository.MedicationRepository;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl {

    public CatalogServiceImpl(
            ActiveIngredientRepository activeIngredientRepository,
            MedicationRepository medicationRepository
    ) {}
}
