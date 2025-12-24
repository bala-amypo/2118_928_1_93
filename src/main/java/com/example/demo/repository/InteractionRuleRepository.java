package com.example.demo.repository;

import com.example.demo.model.InteractionRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InteractionRuleRepository
        extends JpaRepository<InteractionRule, Long> {

    // existing (keep)
    java.util.List<InteractionRule> findByIngredientId(Long id);

    // ✅ REQUIRED by InteractionServiceImpl
    Optional<InteractionRule> findRuleBetweenIngredients(
            Long ingredientAId,
            Long ingredientBId
    );
}
