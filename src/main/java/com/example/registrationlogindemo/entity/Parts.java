package com.example.registrationlogindemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "parts")
public class Parts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_car", nullable = false)
    private Car model;

    @Column(nullable=false)
    private String name;

    @Override
    public String toString() {
        return "Parts{" +
                "name='" + name + '\'' +
                '}';
    }
}