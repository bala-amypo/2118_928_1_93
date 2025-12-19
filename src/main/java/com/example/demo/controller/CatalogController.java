@RestController
@RequestMapping("/ingredient")
public class CatalogController {

    private final IngredientService service;

    public CatalogController(IngredientService service) {
        this.service = service;
    }

    @PostMapping
    public ActiveIngredient add(@RequestBody ActiveIngredient ingredient) {
        return service.addIngredient(ingredient);
    }

    @GetMapping
    public List<ActiveIngredient> getAll() {
        return service.getAllIngredients();
    }
}