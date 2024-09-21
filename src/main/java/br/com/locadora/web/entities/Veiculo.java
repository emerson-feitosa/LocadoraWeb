package br.com.locadora.web.entities;

import br.com.locadora.web.enums.StatusVeiculo;
import br.com.locadora.web.enums.TipoVeiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private Integer anoFabricacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoVeiculo tipoVeiculo;

    @Column(nullable = false)
    private Double precoLocacaoPorDia;

    @Column(nullable = false)
    private Double quilometragem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusVeiculo status;
}
