package com.example.demo.controller;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.Medication;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @PostMapping("/ingredient")
    public void addIngredient(@RequestBody ActiveIngredient ingredient) {
        // Fixed: just call the void method, no assignment
        catalogService.addIngredient(ingredient);
    }

    @PostMapping("/medication")
    public void addMedication(@RequestBody Medication medication) {
        catalogService.addMedication(medication);
    }

    @GetMapping("/medications")
    public List<Medication> getAllMedications() {
        return catalogService.getAllMedications();
    }
}
