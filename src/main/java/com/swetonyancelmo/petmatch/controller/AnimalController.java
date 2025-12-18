package com.swetonyancelmo.petmatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swetonyancelmo.petmatch.dto.Request.CreateAnimalDTO;
import com.swetonyancelmo.petmatch.dto.Request.UpdateAnimalDTO;
import com.swetonyancelmo.petmatch.dto.Response.AnimalDTO;
import com.swetonyancelmo.petmatch.service.AnimalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/animal")
@Tag(name = "Fluxo de Animal", description = "Endpoints CRUD para Animal")
public class AnimalController {
    
    @Autowired
    private AnimalService animalService;

    @PostMapping
    @Operation(summary = "Cadastra um Animal", description = "Faz o cadastro de um novo Animal")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Animal cadastrado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Falha ao cadastrar Animal")
    })
    public ResponseEntity<AnimalDTO> create(@RequestBody @Valid CreateAnimalDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.create(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um Animal", description = "Faz a atualização de um Animal por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Animal atualizado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Animal não encontrado"),
        @ApiResponse(responseCode = "400", description = "Falha ao cadastrar Animal")
    })
    public ResponseEntity<AnimalDTO> update(@PathVariable Long id, @RequestBody UpdateAnimalDTO dto) {
        return ResponseEntity.ok(animalService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um Animal", description = "Faz a exclusão de um Animal por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Animal deletado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Animal não encontrado")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Procura Animais", description = "Retorna todos os Animais cadastrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Animais encontrados com sucesso.")
    })
    public ResponseEntity<List<AnimalDTO>> find() {
        return ResponseEntity.ok(animalService.find());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Procura Animal por ID", description = "Faz a procura de Animal por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Animal encontrado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Animal não encontrado")
    })
    public ResponseEntity<AnimalDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.findById(id));
    }
}
