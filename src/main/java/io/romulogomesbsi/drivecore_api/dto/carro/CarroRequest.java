package io.romulogomesbsi.drivecore_api.dto.carro;

import io.romulogomesbsi.drivecore_api.model.TipoCombustivel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CarroRequest {
    private String marca;
    private String modelo;
    private TipoCombustivel tipoCombustivel;
    private String cor;
    private Integer ano;
    private String chassi;
    private BigDecimal valor;
    private String corExterna;
    private Long concessionariaId;
}