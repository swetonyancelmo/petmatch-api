package com.swetonyancelmo.petmatch.dto.request;

import lombok.Data;

@Data
public class UpdateAnimalDTO {
    
    private String nome;
    private String sexo;
    private String tipo;
    private Boolean adotado;
}
