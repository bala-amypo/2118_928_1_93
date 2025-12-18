package com.example.demo.service;

import com.example.demo.entity.InteractionCheckResult;
import java.util.List;

public interface InteractionService {
    InteractionCheckResult checkInteractions(List<Long> ids);
    InteractionCheckResult getResult(Long id);
}
