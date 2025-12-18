package com.swetonyancelmo.petmatch.dto.Request;

import lombok.Data;

@Data
public class UpdateAnimalDTO {
    
    private String nome;
    private String sexo;
    private String tipo;
    private Boolean adotado;
}
