package com.example.demo.dto;

import java.util.List;

public class InteractionCheckRequest {

    private List<Long> medicationIds;

    public InteractionCheckRequest() {}

    public List<Long> getMedicationIds() {
        return medicationIds;
    }

    public void setMedicationIds(List<Long> medicationIds) {
        this.medicationIds = medicationIds;
    }
}
