package br.edu.ifsp.arq.dw2s6.lista_tarefas.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.lista_tarefas.domain.model.Etiqueta;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.domain.model.Tarefa;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.domain.model.Usuario;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.repository.EtiquetaRepository;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.repository.TarefaRepository;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.repository.UsuarioRepository;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.service.exception.UsuarioOuEtiquetaInexistentesException;

@Service
public class TarefaService {
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EtiquetaRepository etiquetaRepository;
	
	private void verificaUsuarioEtiqueta(Tarefa tarefa) {
		Optional<Usuario> usuario = usuarioRepository.findById(tarefa.getUsuario().getCodigo());
		Optional<Etiqueta> etiqueta = etiquetaRepository.findById(tarefa.getEtiqueta().getCodigo());
		if( !usuario.isPresent() || !etiqueta.isPresent() ) {
			throw new UsuarioOuEtiquetaInexistentesException();
		}
	}
	
	public Tarefa salvar(Tarefa tarefa) {
		verificaUsuarioEtiqueta(tarefa);
		return tarefaRepository.save(tarefa);
	}
	
	public Tarefa atualizar(Long codigo, Tarefa tarefa) {
		Tarefa tarefaSalva = buscarTarefaPeloCodigo(codigo);
		BeanUtils.copyProperties(tarefa, tarefaSalva, "codigo");
		verificaUsuarioEtiqueta(tarefa);
		return this.tarefaRepository.save(tarefaSalva);
	}
	
	private Tarefa buscarTarefaPeloCodigo(Long codigo) {
		Tarefa tarefaSalva = this.tarefaRepository.findById(codigo)
				.orElseThrow(()-> new EmptyResultDataAccessException(1));
		return tarefaSalva;
	}
}
