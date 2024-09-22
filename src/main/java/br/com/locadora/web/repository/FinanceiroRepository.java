package br.com.locadora.web.repository;

import br.com.locadora.web.entities.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {
}
