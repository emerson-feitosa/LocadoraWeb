package br.com.locadora.web.services;

import br.com.locadora.web.entities.Veiculo;
import br.com.locadora.web.enums.StatusVeiculo;
import br.com.locadora.web.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo createVeiculo(Veiculo entity){
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(entity.getModelo());
        veiculo.setMarca(entity.getMarca());
        veiculo.setCor(entity.getCor());
        veiculo.setPlaca(entity.getPlaca());
        veiculo.setAnoFabricacao(entity.getAnoFabricacao());
        veiculo.setTipoVeiculo(entity.getTipoVeiculo());
        veiculo.setPrecoLocacaoPorDia(entity.getPrecoLocacaoPorDia());
        veiculo.setQuilometragem(entity.getQuilometragem());
        veiculo.setStatus(StatusVeiculo.DISPONIVEL);
        veiculoRepository.save(veiculo);
        return veiculo;
    }
}
