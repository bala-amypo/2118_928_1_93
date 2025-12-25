// ActiveIngredientRepository.java
package com.example.demo.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ActiveIngredient;

public interface ActiveIngredientRepository extends JpaRepository<ActiveIngredient, Long> {
    boolean existsByName(String name);
    Optional<ActiveIngredient> findByName(String name);
}
