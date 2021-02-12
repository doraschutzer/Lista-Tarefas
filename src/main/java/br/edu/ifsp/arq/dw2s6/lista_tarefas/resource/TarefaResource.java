package br.edu.ifsp.arq.dw2s6.lista_tarefas.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.lista_tarefas.domain.model.Tarefa;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.repository.TarefaRepository;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaResource {
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private TarefaService tarefaService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_LISTAR_TAREFA') and #oauth2.hasScope('read')")
	public List<Tarefa> listar(){
		return tarefaRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_TAREFA') and #oauth2.hasScope('read')")
	public ResponseEntity<Tarefa> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Tarefa> tarefa = tarefaRepository.findById(codigo);
		if(tarefa.isPresent()) {
			return ResponseEntity.ok(tarefa.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TAREFA') and #oauth2.hasScope('write')")
	public Tarefa criar(@Valid@RequestBody Tarefa tarefa) {
		return tarefaService.salvar(tarefa);
	}
	
	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_TAREFA') and #oauth2.hasScope('write')")
	public ResponseEntity<Tarefa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Tarefa tarefa){
		Tarefa tarefaSalva = tarefaService.atualizar(codigo, tarefa);
		return ResponseEntity.ok(tarefaSalva);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_DELETAR_TAREFA') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long codigo) {
		tarefaRepository.deleteById(codigo);
	}
}
