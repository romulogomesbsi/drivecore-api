package io.romulogomesbsi.drivecore_api.repository;
import io.romulogomesbsi.drivecore_api.model.Concessionaria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConcessionariaRepository
        extends JpaRepository<Concessionaria, Long> {

    Optional<Concessionaria> findByCnpj(String cnpj);

    boolean existsByCnpj(String cnpj);
}
