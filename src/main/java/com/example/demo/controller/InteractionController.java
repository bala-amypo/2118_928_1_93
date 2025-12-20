package com.example.demo.controller;

import com.example.demo.entity.InteractionCheckResult;
import com.example.demo.service.InteractionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/interactions")
public class InteractionController {

    private final InteractionService service;

    public InteractionController(InteractionService service) {
        this.service = service;
    }

    @PostMapping
    public InteractionCheckResult check(@RequestBody Map<String, List<Long>> body) {
        return service.checkInteractions(body.get("medications"));
    }
}
