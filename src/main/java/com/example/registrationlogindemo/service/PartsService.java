package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.entity.Parts;
import com.example.registrationlogindemo.repository.PartsRepository;

import java.util.List;

public class PartsService {
    private final PartsRepository partsRepository;

    public PartsService(PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    public List<Parts> getPartsByModelId(Long modelId) {
        return partsRepository.findByModelId(modelId);
    }

}
