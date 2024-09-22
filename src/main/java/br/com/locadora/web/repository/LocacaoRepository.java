package br.com.locadora.web.repository;

import br.com.locadora.web.entities.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {


}
