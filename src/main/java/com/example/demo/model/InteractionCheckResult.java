package com.example.demo.model;

import java.time.LocalDateTime;

public class InteractionCheckResult {

    private String interactions;
    private LocalDateTime checkedAt;

    public InteractionCheckResult() {
        this.checkedAt = LocalDateTime.now();
    }

    // ✅ REQUIRED by tests
    public String getInteractions() {
        return interactions;
    }

    public void setInteractions(String interactions) {
        this.interactions = interactions;
    }

    // ✅ REQUIRED by tests
    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt = checkedAt;
    }
}
