package br.com.matheusoliveira.algamoney.api.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.matheusoliveira.algamoney.api.model.Lancamento;
import br.com.matheusoliveira.algamoney.api.repository.filter.LancamentoFilter;
import br.com.matheusoliveira.algamoney.api.repository.projection.ResumoLancamento;

public interface LancamentoRepositoryQuery {

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
}
