package com.example.demo.service.impl;

import com.example.demo.model.InteractionCheckResult;
import org.springframework.stereotype.Service;

@Service
public class InteractionServiceImpl {

    public InteractionCheckResult check(String drug1, String drug2) {

        InteractionCheckResult result =
                new InteractionCheckResult();

        result.setMessage("No interaction found");
        result.setSeverity("LOW");

        return result;
    }
}
