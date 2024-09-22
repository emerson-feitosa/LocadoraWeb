package br.com.locadora.web.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("Usuário não encontrado!");
    }
}
