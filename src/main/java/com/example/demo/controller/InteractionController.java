package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.InteractionCheckRequest;
import com.example.demo.model.InteractionCheckResult;
import com.example.demo.service.InteractionService;

@RestController
@RequestMapping("/interact")
public class InteractionController {

    private final InteractionService service;

    public InteractionController(InteractionService service) {
        this.service = service;
    }

    @PostMapping("/check")
    public InteractionCheckResult check(@RequestBody InteractionCheckRequest req) {
        return service.checkInteractions(req.medicationIds);
    }

    @GetMapping("/result/{id}")
    public InteractionCheckResult get(@PathVariable Long id) {
        return service.getResult(id);
    }
}
