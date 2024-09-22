package br.com.locadora.web.dtos;

import br.com.locadora.web.enums.StatusLocacao;
import br.com.locadora.web.enums.StatusUsuario;
import br.com.locadora.web.enums.TipoVeiculo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateLocacaoDto(Long id,
                               Long usuarioId,
                               String nomeUsuario,
                               String emailUsuario,
                               StatusUsuario statusUsuario,

                               Long veiculoId,
                               String modeloVeiculo,
                               String placaVeiculo,
                               TipoVeiculo tipoVeiculo,

                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                               LocalDate dataInicio,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
                               LocalTime horaInicio,

                               Integer diasLocacao,
                               StatusLocacao status,

                               Long financeiroId
                               ) {
}
