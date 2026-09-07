package io.romulogomesbsi.drivecore_api.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O CEP é obrigatório")
    @Column(nullable = false)
    private String cep;

    @NotBlank(message = "O logradouro é obrigatório")
    @Column(nullable = false)
    private String logradouro;

    @NotBlank(message = "O bairro é obrigatório")
    @Column(nullable = false)
    private String bairro;

    @NotBlank(message = "A cidade é obrigatória")
    @Column(nullable = false)
    private String cidade;

    @NotBlank(message = "O estado é obrigatório")
    @Column(nullable = false)
    private String estado;
}

