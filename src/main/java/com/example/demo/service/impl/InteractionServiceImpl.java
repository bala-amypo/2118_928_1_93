package com.example.demo.service.impl;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class InteractionServiceImpl implements InteractionService {


private final MedicationRepository medRepo;
private final InteractionRuleRepository ruleRepo;
private final InteractionCheckResultRepository resultRepo;


public InteractionServiceImpl(MedicationRepository m, InteractionRuleRepository r, InteractionCheckResultRepository i) {
this.medRepo = m;
this.ruleRepo = r;
this.resultRepo = i;
}


public InteractionCheckResult checkInteractions(List<Long> ids) {
List<Medication> meds = medRepo.findAllById(ids);
Set<ActiveIngredient> ingredients = new HashSet<>();
meds.forEach(m -> ingredients.addAll(m.getIngredients()));


int count = 0;
for (ActiveIngredient a : ingredients) {
for (ActiveIngredient b : ingredients) {
if (!a.equals(b) && ruleRepo.findRuleBetweenIngredients(a.getId(), b.getId()).isPresent())
count++;
}
}


String medsStr = meds.stream().map(Medication::getName).reduce((a,b)->a+","+b).orElse("");
String json = "{\"interactionCount\":" + count + "}";


return resultRepo.save(new InteractionCheckResult(medsStr, json));
}


public InteractionCheckResult getResult(Long id) {
return resultRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Result not found"));
}
}