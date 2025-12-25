package com.example.demo.service;

import com.example.demo.model.Interaction;

import java.util.List;

public interface InteractionService {

    Interaction addInteraction(Interaction interaction);

    List<Interaction> getAllInteractions();
}
