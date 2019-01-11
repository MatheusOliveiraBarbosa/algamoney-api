package br.com.matheusoliveira.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matheusoliveira.algamoney.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
