package br.com.locadora.web.exception;

public class VeiculoNotFoundException extends RuntimeException{
    public VeiculoNotFoundException(){
        super("Veiculo não encontrado!");
    }
}
