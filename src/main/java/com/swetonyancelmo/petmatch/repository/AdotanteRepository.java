package com.swetonyancelmo.petmatch.repository;

import com.swetonyancelmo.petmatch.model.Adotante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdotanteRepository extends JpaRepository<Adotante, Long> {
}
