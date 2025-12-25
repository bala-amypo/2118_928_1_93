package com.example.demo.controller;

import com.example.demo.model.Interaction;
import com.example.demo.service.InteractionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interactions")
public class InteractionController {

    private final InteractionService interactionService;

    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @PostMapping
    public Interaction add(@RequestBody Interaction interaction) {
        return interactionService.addInteraction(interaction);
    }

    @GetMapping
    public List<Interaction> getAll() {
        return interactionService.getAllInteractions();
    }
}
