package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.CatalogService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService service) {
        this.service = service;
    }

    @PostMapping("/ingredient")
    public ActiveIngredient addIngredient(@RequestBody ActiveIngredient ingredient) {
        return service.addIngredient(ingredient);
    }

    @PostMapping("/medication")
    public Medication addMedication(@RequestBody Medication medication) {
        return service.addMedication(medication);
    }

    @GetMapping("/medications")
    public List<Medication> getAllMedications() {
        return service.getAllMedications();
    }
}