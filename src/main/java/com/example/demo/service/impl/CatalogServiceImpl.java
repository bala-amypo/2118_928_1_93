package com.example.demo.service.impl;

import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService {

    public CatalogServiceImpl(ActiveIngredientRepository a,
                              MedicationRepository m) {
    }
}
