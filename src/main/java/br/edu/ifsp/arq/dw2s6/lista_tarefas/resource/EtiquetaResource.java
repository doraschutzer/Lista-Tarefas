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

import br.edu.ifsp.arq.dw2s6.lista_tarefas.domain.model.Etiqueta;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.repository.EtiquetaRepository;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.service.EtiquetaService;

@RestController
@RequestMapping("/etiquetas")
public class EtiquetaResource {
	@Autowired
	private EtiquetaRepository etiquetaRepository;
	
	@Autowired
	private EtiquetaService etiquetaService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_LISTAR_ETIQUETA') and #oauth2.hasScope('read')")
	public List<Etiqueta> listar(){
		return etiquetaRepository.findAll();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ETIQUETA') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.CREATED)
	public Etiqueta criar(@Valid@RequestBody Etiqueta etiqueta) {
		return etiquetaRepository.save(etiqueta);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ETIQUETA') and #oauth2.hasScope('read')")
	public ResponseEntity<Etiqueta> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Etiqueta> etiqueta = etiquetaRepository.findById(codigo);
		if(etiqueta.isPresent()) {
			return ResponseEntity.ok(etiqueta.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_DELETAR_ETIQUETA') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		etiquetaRepository.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_ETIQUETA') and #oauth2.hasScope('write')")
	public ResponseEntity<Etiqueta> atualizar(@PathVariable Long codigo, @Valid @RequestBody Etiqueta pessoa){
		Etiqueta etiquetaSalva = etiquetaService.atualizar(codigo, pessoa);
		return ResponseEntity.ok(etiquetaSalva);
	}
}
