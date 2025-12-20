package com.example.demo.dto;

import java.util.List;

public class InteractionRequest {

    private List<Long> medications;

    public List<Long> getMedications() {
        return medications;
    }

    public void setMedications(List<Long> medications) {
        this.medications = medications;
    }
}
