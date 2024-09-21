package br.com.locadora.web.controllers;

import br.com.locadora.web.entities.Veiculo;
import br.com.locadora.web.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public Veiculo createVeiculo(@RequestBody Veiculo veiculo){
        return  veiculoService.createVeiculo(veiculo);
    }
}
