package io.romulogomesbsi.drivecore_api.mapper;

import io.romulogomesbsi.drivecore_api.dto.carro.CarroRequest;
import io.romulogomesbsi.drivecore_api.dto.carro.CarroResponse;
import io.romulogomesbsi.drivecore_api.model.Carro;
import org.springframework.stereotype.Component;

@Component
public class CarroMapper {

    public Carro toEntity(CarroRequest request) {

        Carro carro = new Carro();

        carro.setMarca(request.getMarca());
        carro.setModelo(request.getModelo());
        carro.setTipoCombustivel(request.getTipoCombustivel());
        carro.setCor(request.getCor());
        carro.setAno(request.getAno());
        carro.setChassi(request.getChassi());
        carro.setValor(request.getValor());
        carro.setCorExterna(request.getCorExterna());

        return carro;
    }

    public static CarroResponse toResponse(Carro carro) {
        return new CarroResponse(carro.getId(),
                carro.getMarca(),
                carro.getModelo(),
                carro.getTipoCombustivel(),
                carro.getCor(),
                carro.getAno(),
                carro.getChassi(),
                carro.getValor(),
                carro.getCorExterna(),
                carro.getConcessionaria() != null ?
                        new ConcessionariaMapper().toResponse(carro.getConcessionaria())
                        : null);
    }

    public static void updateEntity(Carro carro, CarroRequest request) {
        carro.setMarca(request.getMarca());
        carro.setModelo(request.getModelo());
        carro.setTipoCombustivel(request.getTipoCombustivel());
        carro.setCor(request.getCor());
        carro.setAno(request.getAno());
        carro.setChassi(request.getChassi());
        carro.setValor(request.getValor());
        carro.setCorExterna(request.getCorExterna());
    }
}