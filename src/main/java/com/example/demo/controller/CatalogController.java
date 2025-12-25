// CatalogController.java
package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.*;
import com.example.demo.service.CatalogService;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService s;

    public CatalogController(CatalogService s) {
        this.s = s;
    }

    @PostMapping("/ingredient")
    public ActiveIngredient add(@RequestBody ActiveIngredient i) {
        return s.addIngredient(i);
    }

    @PostMapping("/medication")
    public Medication add(@RequestBody Medication m) {
        return s.addMedication(m);
    }

    @GetMapping("/medications")
    public List<Medication> all() {
        return s.getAllMedications();
    }
}
