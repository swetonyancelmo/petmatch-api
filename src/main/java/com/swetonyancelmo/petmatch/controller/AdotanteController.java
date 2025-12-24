package com.swetonyancelmo.petmatch.controller;

import com.swetonyancelmo.petmatch.dto.request.CreateAdotanteDTO;
import com.swetonyancelmo.petmatch.dto.request.UpdateAdotanteDTO;
import com.swetonyancelmo.petmatch.dto.response.AdotanteDTO;
import com.swetonyancelmo.petmatch.service.AdotanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adotante")
@Tag(name = "Fluxo de Adotante", description = "Endpoints de CRUD de Adotante")
public class AdotanteController {

    @Autowired
    private AdotanteService adotanteService;

    @PostMapping
    @Operation(summary = "Cadastra um Adotante", description = "Faz o cadastro de um novo Adotante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Adotante cadastrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar o Adotante.")
    })
    public ResponseEntity<AdotanteDTO> create(@RequestBody @Valid CreateAdotanteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adotanteService.create(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um Adotante", description = "Atualiza um Adotante por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Adotante atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Adotante não encontrado."),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar adotante")
    })
    public ResponseEntity<AdotanteDTO> update(@RequestBody @Valid UpdateAdotanteDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok(adotanteService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um Adotante", description = "Deleta um Adotante pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Adotante deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Adotante não encontrado")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        adotanteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Procura Adotantes", description = "Retorna todos os Adotantes cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Adotantes encontrados")
    })
    public ResponseEntity<List<AdotanteDTO>> findAll() {
        return ResponseEntity.ok(adotanteService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Procura Adotante por ID", description = "Faz a procura de um Adotante pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Adotante encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Adotante não encontrado")
    })
    public ResponseEntity<AdotanteDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(adotanteService.findById(id));
    }
}
