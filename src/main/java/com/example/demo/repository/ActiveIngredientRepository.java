public interface ActiveIngredientRepository
        extends JpaRepository<ActiveIngredient, Long> {
    boolean existsByName(String name);
}
