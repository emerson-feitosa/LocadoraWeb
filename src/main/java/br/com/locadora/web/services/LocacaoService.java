package br.com.locadora.web.services;

import br.com.locadora.web.dtos.CreateLocacaoDto;
import br.com.locadora.web.dtos.CreateUserDto;
import br.com.locadora.web.entities.*;
import br.com.locadora.web.enums.StatusFinanceiro;
import br.com.locadora.web.enums.StatusLocacao;
import br.com.locadora.web.enums.StatusUsuario;
import br.com.locadora.web.enums.StatusVeiculo;
import br.com.locadora.web.exception.UserNotFoundException;
import br.com.locadora.web.exception.VeiculoNotFoundException;
import br.com.locadora.web.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class LocacaoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FinanceiroRepository financeiroRepository;

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    @Autowired
    private LocacaoRepository locacaoRepository;


    public CreateLocacaoDto alugarVeiculo(CreateLocacaoDto locacaoDto){
        Usuario usuario = usuarioRepository.findById(locacaoDto.usuarioId())
                .orElseThrow(UserNotFoundException::new);

        usuario.setStatusUsuario(StatusUsuario.DEVEDOR);
        usuarioRepository.save(usuario);

        Veiculo veiculo = veiculoRepository.findById(locacaoDto.veiculoId())
                .orElseThrow(VeiculoNotFoundException::new);

        veiculo.setStatus(StatusVeiculo.ALUGADO);
        veiculoRepository.save(veiculo);


        Financeiro financeiro = new Financeiro();
        financeiro.setValorLocacaoVeiculo(veiculo.getPrecoLocacaoPorDia());
        financeiro.setStatus(StatusFinanceiro.PENDENTE_PAGAMENTO);
        financeiro.setUsuario(usuario);
        financeiroRepository.save(financeiro);


        Locacao locacao = new Locacao();

        locacao.setUsuario(usuario);
        locacao.setVeiculo(veiculo);
        locacao.setDataInicio(LocalDate.now());
        locacao.setHoraInicio(LocalTime.now());
        locacao.setDiasLocacao(locacaoDto.diasLocacao());
        locacao.setStatus(StatusLocacao.EM_ANDAMENTO);
        locacao.setFinanceiro(financeiro);
        locacaoRepository.save(locacao);

        return converterParaDTO(locacao);


    }
    private CreateLocacaoDto converterParaDTO(Locacao locacao){
        return new CreateLocacaoDto(
                locacao.getId(),
                locacao.getUsuario().getId(),
                locacao.getUsuario().getNome(),
                locacao.getUsuario().getEmail(),
                locacao.getUsuario().getStatusUsuario(),
                locacao.getVeiculo().getId(),
                locacao.getVeiculo().getModelo(),
                locacao.getVeiculo().getMarca(),
                locacao.getVeiculo().getTipoVeiculo(),
                locacao.getVeiculo().getStatus(),
                locacao.getDataInicio(),
                locacao.getHoraInicio(),
                locacao.getDiasLocacao(),
                locacao.getStatus(),
                locacao.getFinanceiro().getId(),
                locacao.getFinanceiro().getStatus()
        );
    }
}
