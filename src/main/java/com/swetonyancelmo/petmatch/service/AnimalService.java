package com.swetonyancelmo.petmatch.service;

import com.swetonyancelmo.petmatch.exceptions.ResourceNotFoundException;
import com.swetonyancelmo.petmatch.model.Animal;
import com.swetonyancelmo.petmatch.model.dto.AnimalDTO;
import com.swetonyancelmo.petmatch.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public Animal update(Long id, AnimalDTO.Update dto){
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com o ID: " + id));

        if (dto.nome() != null) animal.setNome(dto.nome());
        if (dto.sexo() != null) animal.setSexo(dto.sexo());
        if (dto.tipo() != null) animal.setTipo(dto.tipo());
        if (dto.adotado() != null) animal.setAdotado(dto.adotado());

        return animalRepository.save(animal);
    }

    @Transactional(readOnly = true)
    public List<Animal> find(){
      return animalRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Animal findById(Long id){
        return animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com o ID: " + id));
    }

    @Transactional
    public void delete(Long id){
        Animal animalEncontrado = animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com o ID: " + id));
        animalRepository.delete(animalEncontrado);
    }

}
