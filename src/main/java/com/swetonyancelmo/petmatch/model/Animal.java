package com.swetonyancelmo.petmatch.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
}
