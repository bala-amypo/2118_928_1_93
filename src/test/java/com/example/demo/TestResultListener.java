package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.controller.*;
import com.example.demo.dto.*;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Listeners(TestResultListener.class)
public class DrugInteractionCheckerTest extends AbstractTestNGSpringContextTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

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

    @Autowired
    private UserService userService;

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private RuleService ruleService;

    @Autowired
    private InteractionService interactionService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    private String baseUrl;
    private String authToken;
    private User testUser;

    @BeforeClass
    public void setUp() {
        baseUrl = "http://localhost:" + port;
        
        // Create test user
        testUser = new User("Test User", "test@example.com", "password", "USER");
        testUser = userService.registerUser(testUser);
        
        // Generate auth token
        authToken = jwtUtil.generateToken(testUser.getId(), testUser.getEmail(), testUser.getRole());
    }

    private HttpHeaders createAuthHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return headers;
    }

    @BeforeMethod
    public void cleanDatabase() {
        resultRepository.deleteAll();
        ruleRepository.deleteAll();
        medicationRepository.deleteAll();
        ingredientRepository.deleteAll();
    }

    @Test
    public void testUserRegistration() {
        RegisterRequest request = new RegisterRequest();
        request.setName("John Doe");
        request.setEmail("john@example.com");
        request.setPassword("password123");
        
        ResponseEntity<User> response = restTemplate.postForEntity(
            baseUrl + "/auth/register", request, User.class);
        
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(response.getBody().getName(), "John Doe");
        Assert.assertEquals(response.getBody().getEmail(), "john@example.com");
        Assert.assertEquals(response.getBody().getRole(), "USER");
    }

    @Test
    public void testUserLogin() {
        LoginRequest request = new LoginRequest();
        request.setEmail(testUser.getEmail());
        request.setPassword("password");
        
        ResponseEntity<Map> response = restTemplate.postForEntity(
            baseUrl + "/auth/login", request, Map.class);
        
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(response.getBody());
        Assert.assertTrue(response.getBody().containsKey("token"));
        Assert.assertTrue(response.getBody().containsKey("user"));
    }

    @Test
    public void testAddIngredient() {
        Map<String, String> request = new HashMap<>();
        request.put("name", "Aspirin");
        
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(request, createAuthHeaders());
        
        ResponseEntity<ActiveIngredient> response = restTemplate.exchange(
            baseUrl + "/catalog/ingredient", HttpMethod.POST, entity, ActiveIngredient.class);
        
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(response.getBody().getName(), "Aspirin");
    }

    @Test
    public void testAddMedication() {
        // First add ingredient
        ActiveIngredient ingredient = catalogService.addIngredient(new ActiveIngredient("Ibuprofen"));
        
        Map<String, Object> request = new HashMap<>();
        request.put("name", "Advil");
        request.put("ingredientIds", Arrays.asList(ingredient.getId()));
        
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, createAuthHeaders());
        
        ResponseEntity<Medication> response = restTemplate.exchange(
            baseUrl + "/catalog/medication", HttpMethod.POST, entity, Medication.class);
        
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(response.getBody().getName(), "Advil");
    }

    @Test
    public void testGetAllMedications() {
        // Add test medication
        ActiveIngredient ingredient = catalogService.addIngredient(new ActiveIngredient("Acetaminophen"));
        Medication medication = new Medication("Tylenol");
        medication.addIngredient(ingredient);
        catalogService.addMedication(medication);
        
        HttpEntity<Void> entity = new HttpEntity<>(createAuthHeaders());
        
        ResponseEntity<List> response = restTemplate.exchange(
            baseUrl + "/catalog/medications", HttpMethod.GET, entity, List.class);
        
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(response.getBody());
        Assert.assertTrue(response.getBody().size() > 0);
    }

    @Test
    public void testAddInteractionRule() {
        // Add ingredients
        ActiveIngredient ingredientA = catalogService.addIngredient(new ActiveIngredient("Warfarin"));
        ActiveIngredient ingredientB = catalogService.addIngredient(new ActiveIngredient("Aspirin"));
        
        Map<String, Object> request = new HashMap<>();
        request.put("ingredientAId", ingredientA.getId());
        request.put("ingredientBId", ingredientB.getId());
        request.put("severity", "MAJOR");
        request.put("description", "Increased bleeding risk");
        
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, createAuthHeaders());
        
        ResponseEntity<InteractionRule> response = restTemplate.exchange(
            baseUrl + "/rules", HttpMethod.POST, entity, InteractionRule.class);
        
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(response.getBody().getSeverity(), "MAJOR");
    }

    @Test
    public void testGetAllRules() {
        // Add test rule
        ActiveIngredient ingredientA = catalogService.addIngredient(new ActiveIngredient("Metformin"));
        ActiveIngredient ingredientB = catalogService.addIngredient(new ActiveIngredient("Insulin"));
        InteractionRule rule = new InteractionRule(ingredientA, ingredientB, "MODERATE", "Monitor blood sugar");
        ruleService.addRule(rule);
        
        HttpEntity<Void> entity = new HttpEntity<>(createAuthHeaders());
        
        ResponseEntity<List> response = restTemplate.exchange(
            baseUrl + "/rules", HttpMethod.GET, entity, List.class);
        
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(response.getBody());
        Assert.assertTrue(response.getBody().size() > 0);
    }

    @Test
    public void testCheckInteractions() {
        // Setup test data
        ActiveIngredient ingredientA = catalogService.addIngredient(new ActiveIngredient("Lisinopril"));
        ActiveIngredient ingredientB = catalogService.addIngredient(new ActiveIngredient("Potassium"));
        
        Medication medA = new Medication("Prinivil");
        medA.addIngredient(ingredientA);
        medA = catalogService.addMedication(medA);
        
        Medication medB = new Medication("K-Tab");
        medB.addIngredient(ingredientB);
        medB = catalogService.addMedication(medB);
        
        InteractionRule rule = new InteractionRule(ingredientA, ingredientB, "MAJOR", "Hyperkalemia risk");
        ruleService.addRule(rule);
        
        Map<String, List<Long>> request = new HashMap<>();
        request.put("medicationIds", Arrays.asList(medA.getId(), medB.getId()));
        
        HttpEntity<Map<String, List<Long>>> entity = new HttpEntity<>(request, createAuthHeaders());
        
        ResponseEntity<InteractionCheckResult> response = restTemplate.exchange(
            baseUrl + "/interact/check", HttpMethod.POST, entity, InteractionCheckResult.class);
        
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(response.getBody());
        Assert.assertNotNull(response.getBody().getInteractions());
    }

    @Test
    public void testGetInteractionResult() {
        // Create test result
        InteractionCheckResult result = new InteractionCheckResult("Test Medication", "{\"totalInteractions\":1}");
        result = resultRepository.save(result);
        
        HttpEntity<Void> entity = new HttpEntity<>(createAuthHeaders());
        
        ResponseEntity<InteractionCheckResult> response = restTemplate.exchange(
            baseUrl + "/interact/result/" + result.getId(), HttpMethod.GET, entity, InteractionCheckResult.class);
        
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(response.getBody().getMedications(), "Test Medication");
    }

    @AfterClass
    public void tearDown() {
        // Cleanup if needed
    }
}