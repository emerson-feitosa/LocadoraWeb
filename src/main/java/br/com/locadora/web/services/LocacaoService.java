package br.com.locadora.web.services;

import br.com.locadora.web.dtos.CreateLocacaoDto;
import br.com.locadora.web.entities.Financeiro;
import br.com.locadora.web.entities.Usuario;
import br.com.locadora.web.entities.Veiculo;
import br.com.locadora.web.exception.UserNotFoundException;
import br.com.locadora.web.exception.VeiculoNotFoundException;
import br.com.locadora.web.repository.LocacaoRepository;
import br.com.locadora.web.repository.UsuarioRepository;
import br.com.locadora.web.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LocacaoRepository locacaoRepository;


    public CreateLocacaoDto createLocacao(CreateLocacaoDto locacaoDto){
        Usuario usuario = usuarioRepository.findById(locacaoDto.usuarioId())
                .orElseThrow(UserNotFoundException::new);

        Veiculo veiculo = veiculoRepository.findById(locacaoDto.financeiroId())
                .orElseThrow(VeiculoNotFoundException::new);

        Financeiro financeiro = new Financeiro();
    }
}
