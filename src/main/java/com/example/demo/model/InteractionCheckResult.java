package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interaction_check_results")
public class InteractionCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medications;

    @Column(length = 4000)
    private String interactions;

    private LocalDateTime checkedAt;

    public InteractionCheckResult() {
        this.checkedAt = LocalDateTime.now();
    }

    public InteractionCheckResult(String medications, String interactions) {
        this.medications = medications;
        this.interactions = interactions;
        this.checkedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getMedications() { return medications; }
    public String getInteractions() { return interactions; }
    public LocalDateTime getCheckedAt() { return checkedAt; }

    public void setId(Long id) { this.id = id; }
}
