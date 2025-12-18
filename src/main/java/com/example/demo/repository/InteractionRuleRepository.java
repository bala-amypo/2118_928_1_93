package com.example.demo.repo;

import com.example.demo.entity.InteractionRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InteractionRuleRepository
        extends JpaRepository<InteractionRule, Long> {
}
