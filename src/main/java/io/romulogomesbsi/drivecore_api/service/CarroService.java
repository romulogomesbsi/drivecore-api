package io.romulogomesbsi.drivecore_api.service;

import io.romulogomesbsi.drivecore_api.dto.carro.CarroRequest;
import io.romulogomesbsi.drivecore_api.dto.carro.CarroResponse;
import io.romulogomesbsi.drivecore_api.exception.RecursoNaoEncontradoException;
import io.romulogomesbsi.drivecore_api.mapper.CarroMapper;
import io.romulogomesbsi.drivecore_api.model.Carro;
import io.romulogomesbsi.drivecore_api.model.Concessionaria;
import io.romulogomesbsi.drivecore_api.repository.CarroRepository;
import io.romulogomesbsi.drivecore_api.repository.ConcessionariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static io.romulogomesbsi.drivecore_api.mapper.CarroMapper.toResponse;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ConcessionariaRepository concessionariaRepository;

    public List<CarroResponse> listar() {
        return carroRepository.findAll()
                .stream()
                .map(CarroMapper::toResponse)
                .collect(toList());
    }

    public CarroResponse buscarPorId(Long id) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Veículo não encontrado para o ID: " + id
                        )
                );

        return toResponse(carro);
    }

    public CarroResponse criar(CarroRequest request) {
        Concessionaria concessionaria = concessionariaRepository.findById(request.getConcessionariaId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Concessionaria não encontrada"
                ));

        Carro carro = new Carro();
        carro.setModelo(request.getModelo());
        carro.setCor(request.getCor());
        carro.setMarca(request.getMarca());
        carro.setChassi(request.getChassi());
        carro.setAno(request.getAno());
        carro.setTipoCombustivel(request.getTipoCombustivel());
        carro.setValor(request.getValor());
        carro.setCorExterna(request.getCorExterna());
        carro.setConcessionaria(concessionaria);


        carroRepository.save(carro);

        return toResponse(carro);
    }

    public CarroResponse atualizar(Long id, CarroRequest request) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Veículo não encontrado para o ID: " + id
                        )
                );
        CarroMapper.updateEntity(carro, request);
        if (request.getConcessionariaId() != null) {
            Concessionaria concessionaria = concessionariaRepository
                    .findById(request.getConcessionariaId())
                    .orElseThrow(() ->
                            new RecursoNaoEncontradoException("Concessionária não encontrada para o ID: " + request.getConcessionariaId()));
            carro.setConcessionaria(concessionaria);
        }
        Carro carroAtualizado = carroRepository.save(carro);

        return toResponse(carroAtualizado);
    }

    public void excluir(Long id) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Veículo não encontrado para o ID: " + id
                        )
                );

        carroRepository.delete(carro);
    }
}
