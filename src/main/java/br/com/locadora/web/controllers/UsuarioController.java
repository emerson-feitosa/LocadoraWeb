package br.com.locadora.web.controllers;

import br.com.locadora.web.dtos.CreateUserDto;
import br.com.locadora.web.entities.Usuario;
import br.com.locadora.web.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

   @Autowired
   private UsuarioService usuarioService;

   @PostMapping
    public CreateUserDto createUser(@RequestBody  Usuario usuario){
        return usuarioService.createUser(usuario);
    }
}
