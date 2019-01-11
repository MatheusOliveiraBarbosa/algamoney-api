package br.com.matheusoliveira.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matheusoliveira.algamoney.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
