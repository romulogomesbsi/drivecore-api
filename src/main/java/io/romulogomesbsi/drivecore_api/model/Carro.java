package io.romulogomesbsi.drivecore_api.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "carros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A marca é obrigatória")
    @Column(nullable = false)
    private String marca;

    @NotBlank(message = "O modelo é obrigatório")
    @Column(nullable = false)
    private String modelo;

    @NotNull(message = "O tipo de combustível é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_combustivel", nullable = false)
    private TipoCombustivel tipoCombustivel;

    @NotBlank(message = "A cor é obrigatória")
    @Column(nullable = false)
    private String cor;

    private Integer ano;

    @Column(unique = true)
    private String chassi;

    @PositiveOrZero(message = "O valor não pode ser negativo")
    @Column(precision = 15, scale = 2)
    private BigDecimal valor;

    @Column(name = "cor_externa")
    private String corExterna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concessionaria_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Concessionaria concessionaria;
}
