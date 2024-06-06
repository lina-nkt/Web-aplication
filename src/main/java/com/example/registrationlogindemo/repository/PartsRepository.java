package com.example.registrationlogindemo.repository;

import com.example.registrationlogindemo.entity.Parts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartsRepository extends JpaRepository<Parts, Long> {
    List<Parts> findByModelId(Long modelId);
}

