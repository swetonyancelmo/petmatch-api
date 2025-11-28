package com.swetonyancelmo.petmatch.service;

import com.swetonyancelmo.petmatch.model.Animal;
import com.swetonyancelmo.petmatch.model.dto.AnimalDTO;
import com.swetonyancelmo.petmatch.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Transactional
    public Animal create(AnimalDTO.Create dto){
        Animal novoAnimal = new Animal();

        novoAnimal.setNome(dto.nome());
        novoAnimal.setSexo(dto.sexo());
        novoAnimal.setTipo(dto.tipo());

        return animalRepository.save(novoAnimal);
    }

    // Terminar CRUD de Animal

}
