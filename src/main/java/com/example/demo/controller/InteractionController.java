package com.example.demo.controller;

import com.example.demo.model.InteractionCheckResult;
import com.example.demo.service.InteractionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/interact")
@Tag(name = "Interactions", description = "Drug interaction checking")
public class InteractionController {
    
    private final InteractionService interactionService;
    
    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }
    
    @PostMapping("/check")
    public ResponseEntity<InteractionCheckResult> checkInteractions(@RequestBody Map<String, List<Long>> request) {
        List<Long> medicationIds = request.get("medicationIds");
        InteractionCheckResult result = interactionService.checkInteractions(medicationIds);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/result/{id}")
    public ResponseEntity<InteractionCheckResult> getResult(@PathVariable Long id) {
        InteractionCheckResult result = interactionService.getResult(id);
        return ResponseEntity.ok(result);
    }
}