package com.example.demo.controller;

import com.example.demo.model.Drug;
import com.example.demo.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/drug")
    public Drug addDrug(@RequestBody Drug drug) {
        return catalogService.addDrug(drug);
    }

    @GetMapping("/drugs")
    public List<Drug> getAllDrugs() {
        return catalogService.getAllDrugs();
    }

    @GetMapping("/drug/{id}")
    public Drug getDrug(@PathVariable Long id) {
        return catalogService.getDrugById(id);
    }
}
