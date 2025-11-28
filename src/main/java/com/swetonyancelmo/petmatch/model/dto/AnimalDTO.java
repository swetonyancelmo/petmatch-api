package com.swetonyancelmo.petmatch.model.dto;

import com.swetonyancelmo.petmatch.model.Animal;
import jakarta.validation.constraints.NotBlank;

public class AnimalDTO {

    public record Create(

            @NotBlank(message = "O nome não pode ser nulo.")
            String nome,

            @NotBlank(message = "O sexo do animal não pode ser nulo.")
            String sexo,

            @NotBlank(message = "O tipo do animal não pode ser nulo.")
            String tipo
    ){}

    public record Response(
            String nome,
            String sexo,
            String tipo
    ){
        public Response(Animal animal){
            this(animal.getNome(), animal.getSexo(), animal.getTipo());
        }
    }
}
