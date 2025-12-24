package com.example.demo.controller;

import com.example.demo.dto.InteractionCheckRequest;
import com.example.demo.model.InteractionCheckResult;
import com.example.demo.service.InteractionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interact")
@Tag(name = "Interactions", description = "Drug interaction checking endpoints")
public class InteractionController {
    private final InteractionService interactionService;
    
    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }
    
    @PostMapping("/check")
    public ResponseEntity<InteractionCheckResult> checkInteractions(@RequestBody InteractionCheckRequest request) {
        return ResponseEntity.ok(interactionService.checkInteractions(request.getMedicationIds()));
    }
    
    @GetMapping("/result/{id}")
    public ResponseEntity<InteractionCheckResult> getResult(@PathVariable Long id) {
        return ResponseEntity.ok(interactionService.getResult(id));
    }
}