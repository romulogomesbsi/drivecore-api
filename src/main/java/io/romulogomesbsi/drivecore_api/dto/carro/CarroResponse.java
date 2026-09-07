package io.romulogomesbsi.drivecore_api.dto.carro;

import io.romulogomesbsi.drivecore_api.dto.concessionaria.ConcessionariaResponse;
import io.romulogomesbsi.drivecore_api.model.TipoCombustivel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarroResponse {

    private Long id;
    private String marca;
    private String modelo;
    private TipoCombustivel tipoCombustivel;
    private String cor;
    private Integer ano;
    private String chassi;
    private BigDecimal valor;
    private String corExterna;
    private ConcessionariaResponse concessionaria;
}