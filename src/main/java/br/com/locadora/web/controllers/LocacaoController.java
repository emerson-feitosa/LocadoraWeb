package br.com.locadora.web.controllers;

import br.com.locadora.web.dtos.CreateLocacaoDto;
import br.com.locadora.web.services.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @PostMapping
    public CreateLocacaoDto alugarVeiculo(@RequestBody CreateLocacaoDto locacaoDto){
        return locacaoService.alugarVeiculo(locacaoDto);
    }
}
