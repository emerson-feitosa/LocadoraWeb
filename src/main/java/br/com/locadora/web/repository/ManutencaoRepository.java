package br.com.locadora.web.repository;

import br.com.locadora.web.entities.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
}
