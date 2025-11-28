package com.swetonyancelmo.petmatch.repository;

import com.swetonyancelmo.petmatch.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
