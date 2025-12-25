package com.example.demo.service;

import java.util.List;

public interface InteractionService {

    String checkInteractions(List<Long> medicationIds);

    String getResult(Long id);
}
