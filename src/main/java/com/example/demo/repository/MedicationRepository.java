package com.example.demo.repo;

import com.example.demo.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository
        extends JpaRepository<Medication, Long> {
}
