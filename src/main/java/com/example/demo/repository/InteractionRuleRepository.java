package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.InteractionRule;

public interface InteractionRuleRepository extends JpaRepository<InteractionRule, Long> {

    @Query("""
        SELECT r FROM InteractionRule r
        WHERE (r.ingredient1.id = :id1 AND r.ingredient2.id = :id2)
           OR (r.ingredient1.id = :id2 AND r.ingredient2.id = :id1)
    """)
    Optional<InteractionRule> findRuleBetweenIngredients(
            @Param("id1") Long id1,
            @Param("id2") Long id2
    );
}
