package br.com.matheusoliveira.algamoney.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.matheusoliveira.algamoney.api.model.Pessoa;
import br.com.matheusoliveira.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepo;
	
	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Pessoa pessoaBD = this.buscarPorID(id);
		BeanUtils.copyProperties(pessoa, pessoaBD, "id");
		return pessoaRepo.save(pessoaBD);
	}
	
	public void deletar(Long id) {
		Pessoa pessoaBD = this.buscarPorID(id);
		pessoaRepo.delete(pessoaBD);
	}
	
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepo.save(pessoa);
	}
	
	public List<Pessoa> listarTodos(){
		return pessoaRepo.findAll();
	}
	
	public Pessoa buscarPorID(Long id) {
		Optional<Pessoa> pessoaEncontrada = pessoaRepo.findById(id);
		if(pessoaEncontrada.isPresent()) {
			return pessoaEncontrada.get();
		}
		throw new EmptyResultDataAccessException(1);
	}

	public void atualizarAtivo(Long id, Boolean ativo) {
		Pessoa pessoaAtualizarAtivo = buscarPorID(id);
		pessoaAtualizarAtivo.setAtivo(ativo);
		pessoaRepo.save(pessoaAtualizarAtivo);
	}
	
}
