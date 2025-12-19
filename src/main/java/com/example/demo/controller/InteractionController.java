package com.example.demo.controller;

import com.example.demo.entity.InteractionCheckResult;
import com.example.demo.service.InteractionService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/interactions")
public class InteractionController {

    private final InteractionService service;

    public InteractionController(InteractionService service) {
        this.service = service;
    }

    @PostMapping
    public InteractionCheckResult save(@RequestBody InteractionCheckResult result) {
        return service.saveResult(result);
    }
}