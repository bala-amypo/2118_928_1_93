package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.InteractionRule;

public interface InteractionRuleRepository extends JpaRepository<InteractionRule, Long> {

    @Query("""
        SELECT r FROM InteractionRule r
        WHERE 
        (r.ingredientA.id = :a AND r.ingredientB.id = :b)
        OR
        (r.ingredientA.id = :b AND r.ingredientB.id = :a)
    """)
    Optional<InteractionRule> findRuleBetweenIngredients(
            @Param("a") Long ingredientAId,
            @Param("b") Long ingredientBId
    );
}
