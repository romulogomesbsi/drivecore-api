package io.romulogomesbsi.drivecore_api.dto.concessionaria;

import io.romulogomesbsi.drivecore_api.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConcessionariaResponse {
    private Long id;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
}