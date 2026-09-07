package io.romulogomesbsi.drivecore_api.mapper;

import io.romulogomesbsi.drivecore_api.dto.concessionaria.ConcessionariaRequest;
import io.romulogomesbsi.drivecore_api.dto.concessionaria.ConcessionariaResponse;
import io.romulogomesbsi.drivecore_api.model.Concessionaria;
import org.springframework.stereotype.Component;

@Component
public class ConcessionariaMapper {
    public Concessionaria toEntity(ConcessionariaRequest request) {
        if (request == null) {
            return null;
        }
        Concessionaria concessionaria = new Concessionaria();
        concessionaria.setRazaoSocial(request.getRazaoSocial());
        concessionaria.setCnpj(request.getCnpj());
        concessionaria.setEndereco(request.getEndereco());
        return concessionaria;
    }

    public ConcessionariaResponse toResponse(Concessionaria concessionaria) {
        if (concessionaria == null) {
            return null;
        }
        ConcessionariaResponse response = new ConcessionariaResponse();
        response.setId(concessionaria.getId());
        response.setRazaoSocial(concessionaria.getRazaoSocial());
        response.setCnpj(concessionaria.getCnpj());
        response.setEndereco(concessionaria.getEndereco());
        return response;
    }

    public void updateEntity(Concessionaria concessionaria, ConcessionariaRequest request) {
        if (concessionaria == null || request == null) {
            return;
        }
        concessionaria.setRazaoSocial(request.getRazaoSocial());
        concessionaria.setCnpj(request.getCnpj());
        concessionaria.setEndereco(request.getEndereco());
    }
}