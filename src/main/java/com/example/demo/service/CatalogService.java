package com.example.demo.service;

import com.example.demo.model.Drug;

import java.util.List;

public interface CatalogService {

    Drug addDrug(Drug drug);

    List<Drug> getAllDrugs();

    Drug getDrugById(Long id);
}
