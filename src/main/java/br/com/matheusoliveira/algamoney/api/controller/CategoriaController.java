package br.com.matheusoliveira.algamoney.api.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheusoliveira.algamoney.api.event.RecursoCriadoEvent;
import br.com.matheusoliveira.algamoney.api.model.Categoria;
import br.com.matheusoliveira.algamoney.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public List<Categoria> listarTodos() {
		return categoriaRepo.findAll();
	}

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
	public ResponseEntity<Categoria> criarCategoria(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		
		Categoria categoriaCriada = categoriaRepo.save(categoria);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaCriada.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaCriada);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public ResponseEntity<Categoria> buscarPorID(@PathVariable Long id) {
		Optional<Categoria> categoriaEncontrada = categoriaRepo.findById(id);
		if(categoriaEncontrada.isPresent()) {
			return ResponseEntity.ok(categoriaEncontrada.get());
		}
		return ResponseEntity.notFound().build();
	}

}
