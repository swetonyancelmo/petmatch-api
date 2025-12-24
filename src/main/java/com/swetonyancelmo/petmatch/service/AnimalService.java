package com.swetonyancelmo.petmatch.service;

import com.swetonyancelmo.petmatch.dto.response.AnimalDTO;
import com.swetonyancelmo.petmatch.dto.request.CreateAnimalDTO;
import com.swetonyancelmo.petmatch.dto.request.UpdateAnimalDTO;
import com.swetonyancelmo.petmatch.exceptions.ResourceNotFoundException;
import com.swetonyancelmo.petmatch.mapper.AnimalMapper;
import com.swetonyancelmo.petmatch.model.Animal;
import com.swetonyancelmo.petmatch.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AnimalMapper animalMapper;

    @Transactional
    public AnimalDTO create(CreateAnimalDTO dto){
        Animal novoAnimal = new Animal();

        novoAnimal.setNome(dto.getNome());
        novoAnimal.setSexo(dto.getSexo());
        novoAnimal.setTipo(dto.getTipo());

        Animal animalCadastrado = animalRepository.save(novoAnimal);

        return animalMapper.tDto(animalCadastrado);
    }

    @Transactional
    public AnimalDTO update(Long id, UpdateAnimalDTO dto){
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com o ID: " + id));

        if (dto.getNome() != null) animal.setNome(dto.getNome());
        if (dto.getSexo() != null) animal.setSexo(dto.getSexo());
        if (dto.getTipo() != null) animal.setTipo(dto.getTipo());
        if (dto.getAdotado() != null) animal.setAdotado(dto.getAdotado());

        Animal animalAtualizado = animalRepository.save(animal);

        return animalMapper.tDto(animalAtualizado);
    }

    @Transactional(readOnly = true)
    public List<AnimalDTO> find(){
      return animalRepository.findAll()
            .stream()
            .map(animalMapper::tDto)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AnimalDTO findById(Long id){
        return animalRepository.findById(id)
               .map(animalMapper::tDto)
               .orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com o ID: " + id));
    }

    @Transactional
    public void delete(Long id){
        Animal animalEncontrado = animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com o ID: " + id));
        animalRepository.delete(animalEncontrado);
    }

}
