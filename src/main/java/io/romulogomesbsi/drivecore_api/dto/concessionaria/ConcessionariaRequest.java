package io.romulogomesbsi.drivecore_api.dto.concessionaria;

import io.romulogomesbsi.drivecore_api.model.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConcessionariaRequest {
    @NotBlank(message = "Razão Social é obrigatória")
    private String razaoSocial;
    @NotBlank(message = "CNPJ é obrigatório")
    private String cnpj;
    @Valid
    @NotNull(message = "Endereço é obrigatório")
    private Endereco endereco;
}