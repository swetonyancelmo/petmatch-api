package com.swetonyancelmo.petmatch.mapper;

import com.swetonyancelmo.petmatch.dto.request.CreateAdotanteDTO;
import com.swetonyancelmo.petmatch.dto.request.UpdateAnimalDTO;
import com.swetonyancelmo.petmatch.dto.response.AdotanteDTO;
import com.swetonyancelmo.petmatch.model.Adotante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AdotanteMapper {

    public static final AdotanteMapper INSTANCE = Mappers.getMapper(AdotanteMapper.class);

    public abstract Adotante toEntity (CreateAdotanteDTO dto);

    public abstract Adotante toEntity (UpdateAnimalDTO dto);

    public abstract Adotante toAdotante (AdotanteDTO dto);

    public abstract AdotanteDTO toDto (Adotante adotante);
}
