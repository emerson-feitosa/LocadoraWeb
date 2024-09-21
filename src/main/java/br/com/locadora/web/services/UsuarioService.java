package br.com.locadora.web.services;

import br.com.locadora.web.dtos.CreateUserDto;
import br.com.locadora.web.entities.Usuario;
import br.com.locadora.web.enums.StatusUsuario;
import br.com.locadora.web.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public CreateUserDto createUser(Usuario entidade){

        Usuario usuario = new Usuario();
        usuario.setLogin(entidade.getLogin());
        usuario.setSenha(entidade.getSenha());
        usuario.setNome(entidade.getNome());
        usuario.setEmail(entidade.getEmail());
        usuario.setTelefone(entidade.getTelefone());
        usuario.setCpf(entidade.getCpf());
        usuario.setCnh(entidade.getCnh());
        usuario.setStatusUsuario(StatusUsuario.REGULAR);
        usuario.setTipo(entidade.getTipo());
        usuarioRepository.save(usuario);

        return converterParaDTO(usuario);
    }




    private CreateUserDto converterParaDTO(Usuario usuario){
        return new CreateUserDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getStatusUsuario(),
                usuario.getTipo()
        );
    }
}
