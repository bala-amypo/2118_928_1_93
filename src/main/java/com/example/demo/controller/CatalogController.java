package com.example.demo.controller;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.Medication;
import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.service.CatalogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
@Tag(name = "Catalog", description = "Ingredient and medication management")
public class CatalogController {
    
    private final CatalogService catalogService;
    private final ActiveIngredientRepository ingredientRepository;
    
    public CatalogController(CatalogService catalogService, ActiveIngredientRepository ingredientRepository) {
        this.catalogService = catalogService;
        this.ingredientRepository = ingredientRepository;
    }
    
    @PostMapping("/ingredient")
    public ResponseEntity<ActiveIngredient> addIngredient(@RequestBody Map<String, String> request) {
        ActiveIngredient ingredient = new ActiveIngredient(request.get("name"));
        ActiveIngredient saved = catalogService.addIngredient(ingredient);
        return ResponseEntity.ok(saved);
    }
    
    @PostMapping("/medication")
    public ResponseEntity<Medication> addMedication(@RequestBody Map<String, Object> request) {
        String name = (String) request.get("name");
        @SuppressWarnings("unchecked")
        List<Long> ingredientIds = (List<Long>) request.get("ingredientIds");
        
        Medication medication = new Medication(name);
        Set<ActiveIngredient> ingredients = ingredientIds.stream()
                .map(id -> ingredientRepository.findById(id).orElseThrow())
                .collect(Collectors.toSet());
        medication.setIngredients(ingredients);
        
        Medication saved = catalogService.addMedication(medication);
        return ResponseEntity.ok(saved);
    }
    
    @GetMapping("/medications")
    public ResponseEntity<List<Medication>> getAllMedications() {
        List<Medication> medications = catalogService.getAllMedications();
        return ResponseEntity.ok(medications);
    }
}