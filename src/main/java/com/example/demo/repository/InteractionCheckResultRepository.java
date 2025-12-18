package com.example.demo.repo;

import com.example.demo.entity.InteractionCheckResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InteractionCheckResultRepository
        extends JpaRepository<InteractionCheckResult, Long> {
}
