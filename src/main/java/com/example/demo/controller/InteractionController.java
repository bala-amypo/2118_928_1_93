package com.example.demo.controller;

import com.example.demo.dto.InteractionRequest;
import com.example.demo.entity.InteractionCheckResult;
import com.example.demo.service.InteractionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interactions")
@CrossOrigin(origins = "*")
public class InteractionController {

    private final InteractionService service;

    public InteractionController(InteractionService service) {
        this.service = service;
    }

    // POST /interactions
    @PostMapping
    public InteractionCheckResult checkInteractions(
            @RequestBody InteractionRequest request) {
        return service.checkInteractions(request.getMedications());
    }

    // GET /interactions/result/{id}
    @GetMapping("/result/{id}")
    public InteractionCheckResult getResultById(@PathVariable Long id) {
        return service.getResultById(id);
    }
}
