package br.com.locadora.web.dtos;

import br.com.locadora.web.enums.StatusUsuario;

public record CreateUserDto(Long id,
                            String nome,
                            String email,
                            String telefone,
                            StatusUsuario status) {
}
