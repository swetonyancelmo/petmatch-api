package com.swetonyancelmo.petmatch.service;

import com.swetonyancelmo.petmatch.dto.request.CreateAdotanteDTO;
import com.swetonyancelmo.petmatch.dto.request.UpdateAdotanteDTO;
import com.swetonyancelmo.petmatch.dto.response.AdotanteDTO;
import com.swetonyancelmo.petmatch.exceptions.ResourceNotFoundException;
import com.swetonyancelmo.petmatch.mapper.AdotanteMapper;
import com.swetonyancelmo.petmatch.model.Adotante;
import com.swetonyancelmo.petmatch.repository.AdotanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdotanteService {

    @Autowired
    private AdotanteRepository adotanteRepository;

    @Autowired
    private AdotanteMapper adotanteMapper;

    @Transactional
    public AdotanteDTO create(CreateAdotanteDTO dto) {
        Adotante novoAdotante = new Adotante();

        novoAdotante.setNome(dto.getNome());
        novoAdotante.setCpf(dto.getCpf());

        Adotante adotanteCadastrado = adotanteRepository.save(novoAdotante);
        return adotanteMapper.toDto(adotanteCadastrado);
    }

    @Transactional
    public AdotanteDTO update(Long id, UpdateAdotanteDTO dto) {
        Adotante adotante = adotanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Adotande não encontrado com o ID: " + id));

        if(dto.getNome() != null) adotante.setNome(dto.getNome());
        if(dto.getCpf() != null) adotante.setCpf(dto.getCpf());

        Adotante adotanteAtualizado = adotanteRepository.save(adotante);

        return adotanteMapper.toDto(adotanteAtualizado);
    }

    @Transactional(readOnly = true)
    public List<AdotanteDTO> findAll() {
        return adotanteRepository.findAll()
                .stream()
                .map(adotanteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AdotanteDTO findById(Long id) {
        return adotanteRepository.findById(id)
                .map(adotanteMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Adotande não encontrado com o ID: " + id));
    }

    @Transactional
    public void delete(Long id) {
        Adotante adotanteEncontrado = adotanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Adotande não encontrado com o ID: " + id));
        adotanteRepository.delete(adotanteEncontrado);
    }
}
