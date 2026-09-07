package io.romulogomesbsi.drivecore_api.controller;

import io.romulogomesbsi.drivecore_api.dto.concessionaria.ConcessionariaRequest;
import io.romulogomesbsi.drivecore_api.dto.concessionaria.ConcessionariaResponse;
import io.romulogomesbsi.drivecore_api.service.ConcessionariaService;
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
@RequestMapping("/dealer")
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "Dealer", description = "Endpoints dos Concessionárias")
@Slf4j
public class ConcessionariaController {
    @Autowired
    private ConcessionariaService concessionariaService;

    @GetMapping
    @Operation(summary = "Listar todas as Concessionárias")
    public ResponseEntity<List<ConcessionariaResponse>> listar() {
        return ResponseEntity.ok(concessionariaService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar concessionária por ID")
    public ResponseEntity<ConcessionariaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(concessionariaService.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar concessionária")
    public ResponseEntity<ConcessionariaResponse> criar(@Valid @RequestBody ConcessionariaRequest request) {
        log.info("Cadastrando nova concessionária {}", request.getRazaoSocial());
        ConcessionariaResponse criada = concessionariaService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar concessionária")
    public ResponseEntity<ConcessionariaResponse> atualizar(@PathVariable Long id, @Valid @RequestBody ConcessionariaRequest request) {
        log.info("Atualizando concessionária {}", request.getRazaoSocial());
        return ResponseEntity.ok(concessionariaService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Excluir concessionária")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        log.info("Removendo concessionária {}",id);
        concessionariaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}