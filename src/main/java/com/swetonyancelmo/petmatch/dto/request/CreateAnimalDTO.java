package com.swetonyancelmo.petmatch.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateAnimalDTO {
    
    @NotBlank(message = "O nome não pode ser nulo.")
    String nome;

    @NotBlank(message = "O sexo do animal não pode ser nulo.")
    String sexo;

    @NotBlank(message = "O tipo do animal não pode ser nulo.")
    String tipo;
}
