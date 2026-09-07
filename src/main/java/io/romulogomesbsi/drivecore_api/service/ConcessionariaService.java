package io.romulogomesbsi.drivecore_api.service;

import io.romulogomesbsi.drivecore_api.dto.concessionaria.ConcessionariaRequest;
import io.romulogomesbsi.drivecore_api.dto.concessionaria.ConcessionariaResponse;
import io.romulogomesbsi.drivecore_api.exception.RecursoNaoEncontradoException;
import io.romulogomesbsi.drivecore_api.mapper.ConcessionariaMapper;
import io.romulogomesbsi.drivecore_api.model.Concessionaria;
import io.romulogomesbsi.drivecore_api.repository.ConcessionariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcessionariaService {
    @Autowired
    private ConcessionariaRepository concessionariaRepository;
    @Autowired
    private ConcessionariaMapper concessionariaMapper;

    public List<ConcessionariaResponse> listar() {
        return concessionariaRepository.findAll().stream().map(concessionariaMapper::toResponse).toList();
    }

    public ConcessionariaResponse buscarPorId(Long id) {
        Concessionaria concessionaria = concessionariaRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Concessionária não encontrada para o ID: " + id));
        return concessionariaMapper.toResponse(concessionaria);
    }

    public ConcessionariaResponse criar(ConcessionariaRequest request) {
        Concessionaria concessionaria = concessionariaMapper.toEntity(request);
        Concessionaria novaConcessionaria = concessionariaRepository.save(concessionaria);
        return concessionariaMapper.toResponse(novaConcessionaria);
    }

    public ConcessionariaResponse atualizar(Long id, ConcessionariaRequest request) {
        Concessionaria concessionaria = concessionariaRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Concessionária não encontrada para o ID: " + id));
        concessionariaMapper.updateEntity(concessionaria, request);
        Concessionaria concessionariaAtualizada = concessionariaRepository.save(concessionaria);
        return concessionariaMapper.toResponse(concessionariaAtualizada);
    }

    public void excluir(Long id) {
        Concessionaria concessionaria = concessionariaRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Concessionária não encontrada para o ID: " + id));
        concessionariaRepository.delete(concessionaria);
    }
}