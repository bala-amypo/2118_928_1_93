package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interaction_results")
public class InteractionCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medications;

    @Column(length = 2000)
    private String interactions;

    private LocalDateTime checkedAt = LocalDateTime.now();

    public InteractionCheckResult() {}

    public InteractionCheckResult(String m, String i) {
        this.medications = m;
        this.interactions = i;
    }

    public Long getId() { return id; }
    public String getMedications() { return medications; }
    public String getInteractions() { return interactions; }
    public LocalDateTime getCheckedAt() { return checkedAt; }
}
