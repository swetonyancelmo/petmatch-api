package com.swetonyancelmo.petmatch.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateAdotanteDTO {

    @NotBlank(message = "O nome não pode ser nulo.")
    private String nome;

    @NotBlank(message = "O CPF não pode ser nulo.")
    private String cpf;

}
