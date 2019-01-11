package br.com.matheusoliveira.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.matheusoliveira.algamoney.api.model.Lancamento;
import br.com.matheusoliveira.algamoney.api.model.Pessoa;
import br.com.matheusoliveira.algamoney.api.repository.LancamentoRepository;
import br.com.matheusoliveira.algamoney.api.repository.PessoaRepository;
import br.com.matheusoliveira.algamoney.api.repository.filter.LancamentoFilter;
import br.com.matheusoliveira.algamoney.api.repository.projection.ResumoLancamento;
import br.com.matheusoliveira.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepo;
	
	@Autowired
	private PessoaRepository pessoaRepo;
	
	public Lancamento salvar(Lancamento lancamento) {
		Optional<Pessoa> pessoaBD = pessoaRepo.findById(lancamento.getPessoa().getId());
		if(pessoaBD.isPresent()) {
			if(pessoaBD.get().getAtivo()) {
				return lancamentoRepo.save(lancamento);
			}
		}
		throw new PessoaInexistenteOuInativaException();
	}
	
	public void deletar(Long id) {
		Lancamento lancamentoBD = buscarPorId(id);
		lancamentoRepo.delete(lancamentoBD);
	}
	
	public Lancamento atualizar(Long id, Lancamento lancamento) {
		Lancamento lancamentoBD = buscarPorId(id);
		BeanUtils.copyProperties(lancamento, lancamentoBD, "id");
		return lancamentoRepo.save(lancamentoBD);
	}
	
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable){
		return lancamentoRepo.filtrar(lancamentoFilter, pageable);
	}
	
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable){
		return lancamentoRepo.resumir(lancamentoFilter, pageable);
	}
	
	public Lancamento buscarPorId(Long id) {
		Optional<Lancamento> lancamentoEncontrado = lancamentoRepo.findById(id);
		if(lancamentoEncontrado.isPresent()) {
			return lancamentoEncontrado.get();
		}
		throw new EmptyResultDataAccessException(1);
	}
}
