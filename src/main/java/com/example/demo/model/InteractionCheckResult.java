package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InteractionCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String interactions;
    private String severity;

    private LocalDateTime checkedAt = LocalDateTime.now();

    // ✅ REQUIRED BY TEST
    public InteractionCheckResult(String interactions, String severity) {
        this.interactions = interactions;
        this.severity = severity;
        this.checkedAt = LocalDateTime.now();
    }
}
