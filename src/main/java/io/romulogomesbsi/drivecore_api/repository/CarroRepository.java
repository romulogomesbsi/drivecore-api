package io.romulogomesbsi.drivecore_api.repository;

import io.romulogomesbsi.drivecore_api.dto.carro.CarroRequest;
import io.romulogomesbsi.drivecore_api.dto.carro.CarroResponse;
import io.romulogomesbsi.drivecore_api.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByConcessionariaId(Long concessionariaId);
}
