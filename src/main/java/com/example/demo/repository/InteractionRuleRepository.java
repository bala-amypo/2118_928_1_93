package com.example.demo.repository;

import com.example.demo.model.InteractionRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InteractionRuleRepository
        extends JpaRepository<InteractionRule, Long> {

    // ✅ REQUIRED by tests
    List<InteractionRule> findByIngredientId(Long id);
}
