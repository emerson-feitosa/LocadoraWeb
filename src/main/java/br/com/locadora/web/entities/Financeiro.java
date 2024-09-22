package br.com.locadora.web.entities;

import br.com.locadora.web.enums.StatusFinanceiro;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "financas")
public class Financeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manutencao_id")
    private Manutencao manutencao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataPagamento;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime horaPagamento;

    @Column(nullable = false)
    private Double valorLocacaoVeiculo;

    private Integer diasAtraso;

    private Double multaAtraso;

    private Double multaAvaria;

    private Double valorTotalFatura;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusFinanceiro status;
}
