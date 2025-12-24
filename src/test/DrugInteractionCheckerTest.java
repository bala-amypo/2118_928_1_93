package com.example.demo;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.InteractionCheckResult;
import com.example.demo.model.InteractionRule;
import com.example.demo.model.Medication;
import com.example.demo.model.User;
import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.repository.InteractionCheckResultRepository;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.service.InteractionService;
import com.example.demo.service.RuleService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class DrugInteractionCheckerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private RuleService ruleService;

    @Autowired
    private InteractionService interactionService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActiveIngredientRepository ingredientRepository;

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private InteractionRuleRepository ruleRepository;

    @Autowired
    private InteractionCheckResultRepository resultRepository;

    private User user1;

    @BeforeEach
    public void setup() {
        user1 = new User("Alice", "alice@example.com", "password123", "USER");
        user1 = userService.registerUser(user1);
    }

    @Test
    public void testUserRegistrationAndPasswordEncoding() {
        User found = userService.findByEmail("alice@example.com");
        assertNotNull(found);
        assertTrue(passwordEncoder.matches("password123", found.getPassword()));
        assertEquals("USER", found.getRole());
    }

    @Test
    public void testAddIngredientAndMedication() {
        ActiveIngredient ing1 = new ActiveIngredient("Paracetamol");
        ActiveIngredient ing2 = new ActiveIngredient("Ibuprofen");
        ing1 = catalogService.addIngredient(ing1);
        ing2 = catalogService.addIngredient(ing2);

        Medication med = new Medication("PainRelief");
        med.addIngredient(ing1);
        med.addIngredient(ing2);

        med = catalogService.addMedication(med);

        List<Medication> meds = catalogService.getAllMedications();
        assertEquals(1, meds.size());
        assertEquals(2, meds.get(0).getIngredients().size());
    }

    @Test
    public void testAddInteractionRule() {
        ActiveIngredient ing1 = catalogService.addIngredient(new ActiveIngredient("Aspirin"));
        ActiveIngredient ing2 = catalogService.addIngredient(new ActiveIngredient("Warfarin"));

        InteractionRule rule = new InteractionRule(ing1, ing2, "MAJOR", "Severe bleeding risk");
        rule = ruleService.addRule(rule);

        List<InteractionRule> rules = ruleService.getAllRules();
        assertEquals(1, rules.size());
        assertEquals("MAJOR", rules.get(0).getSeverity());
    }

    @Test
    public void testInteractionCheckResult() {
        ActiveIngredient ing1 = catalogService.addIngredient(new ActiveIngredient("DrugA"));
        ActiveIngredient ing2 = catalogService.addIngredient(new ActiveIngredient("DrugB"));

        Medication med1 = new Medication("MedA");
        med1.addIngredient(ing1);
        med1 = catalogService.addMedication(med1);

        Medication med2 = new Medication("MedB");
        med2.addIngredient(ing2);
        med2 = catalogService.addMedication(med2);

        InteractionCheckResult result = interactionService.checkInteractions(
                List.of(med1.getId(), med2.getId())
        );

        assertNotNull(result);
        assertTrue(result.getMedications().contains("MedA"));
        assertTrue(result.getMedications().contains("MedB"));

        InteractionCheckResult fetched = interactionService.getResult(result.getId());
        assertEquals(result.getId(), fetched.getId());
    }
}
