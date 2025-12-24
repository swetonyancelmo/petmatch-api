package com.swetonyancelmo.petmatch.repository;

import com.swetonyancelmo.petmatch.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
