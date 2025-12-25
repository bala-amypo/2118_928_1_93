package com.example.demo.service.impl;

import com.example.demo.model.Drug;
import com.example.demo.repository.DrugRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final DrugRepository drugRepository;

    public CatalogServiceImpl(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Override
    public Drug addDrug(Drug drug) {
        return drugRepository.save(drug);
    }

    @Override
    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

    @Override
    public Drug getDrugById(Long id) {
        return drugRepository.findById(id).orElse(null);
    }
}
