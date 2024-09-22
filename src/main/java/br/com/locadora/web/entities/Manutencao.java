package br.com.locadora.web.entities;

import br.com.locadora.web.enums.StatusManutencao;
import br.com.locadora.web.enums.TipoManutencao;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoManutencao tipo;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private String causa;

    @Column(nullable = false)
    private String descriccao;

    @Column(nullable = false)
    private Boolean avaria;

    @Column(nullable = false)
    private Double custoReparoAvaria;


    private LocalDate dataFim;
    private LocalTime horaFim;


    private Double custoTotal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusManutencao status;


}
