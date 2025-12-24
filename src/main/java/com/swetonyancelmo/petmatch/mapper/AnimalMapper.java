package com.swetonyancelmo.petmatch.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.swetonyancelmo.petmatch.dto.request.CreateAnimalDTO;
import com.swetonyancelmo.petmatch.dto.request.UpdateAnimalDTO;
import com.swetonyancelmo.petmatch.dto.response.AnimalDTO;
import com.swetonyancelmo.petmatch.model.Animal;

@Mapper(componentModel = "spring")
public abstract class AnimalMapper {
    
    public static final AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    public abstract Animal toEntity (CreateAnimalDTO dto);

    public abstract Animal toEntity (UpdateAnimalDTO dto);

    public abstract Animal toAnimal (AnimalDTO dto);

    public abstract AnimalDTO tDto (Animal animal);
}
