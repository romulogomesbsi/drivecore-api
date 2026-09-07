package io.romulogomesbsi.drivecore_api.controller;

import io.romulogomesbsi.drivecore_api.dto.carro.CarroRequest;
import io.romulogomesbsi.drivecore_api.dto.carro.CarroResponse;
import io.romulogomesbsi.drivecore_api.service.CarroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "Vehicles", description = "Endpoints dos Vehicles")
@Slf4j
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    @Operation(summary = "Listar todos os carros")
    public ResponseEntity<List<CarroResponse>> listar() {
        return ResponseEntity.ok(
                carroService.listar()
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar carro por ID")
    public ResponseEntity<CarroResponse> buscarPorId(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                carroService.buscarPorId(id)
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar carro")
    public ResponseEntity<CarroResponse> criar(
            @Valid @RequestBody CarroRequest carroRequest
    ) {
        log.info("Cadastrando novo carro {}", carroRequest.getMarca() + carroRequest.getModelo());
        CarroResponse novoCarro = carroService.criar(carroRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novoCarro);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar carro")
    public ResponseEntity<CarroResponse> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody CarroRequest carroRequest
    ) {
        log.info("Atualizando carro {}", id + " " + carroRequest.getMarca() + " " + carroRequest.getModelo());
        return ResponseEntity.ok(
                carroService.atualizar(id, carroRequest)
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Excluir carro")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id
    ) {

        log.info("Excluindo carro {}", id);
        carroService.excluir(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
