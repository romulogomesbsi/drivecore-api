package io.romulogomesbsi.drivecore_api.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "concessionarias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Concessionaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A razão social é obrigatória")
    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @NotBlank(message = "O CNPJ é obrigatório")
    @Column(nullable = false, unique = true)
    private String cnpj;

    @Valid
    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            optional = false
    )
    @JoinColumn(
            name = "endereco_id",
            nullable = false,
            unique = true
    )
    private Endereco endereco;

    @OneToMany(mappedBy = "concessionaria")
    @JsonIgnore
    private List<Carro> carros = new ArrayList<>();
}



