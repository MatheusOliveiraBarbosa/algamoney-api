package br.com.matheusoliveira.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matheusoliveira.algamoney.api.model.Lancamento;
import br.com.matheusoliveira.algamoney.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
