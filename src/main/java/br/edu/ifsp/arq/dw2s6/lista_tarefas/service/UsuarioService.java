package br.edu.ifsp.arq.dw2s6.lista_tarefas.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.lista_tarefas.domain.model.Usuario;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario atualizar(Long codigo, Usuario usuario) {
		Usuario usuarioSalva = buscarUsuarioPeloCodigo(codigo);
		BeanUtils.copyProperties(usuario, usuarioSalva, "codigo");
		return this.usuarioRepository.save(usuarioSalva);
	}
	
	private Usuario buscarUsuarioPeloCodigo(Long codigo) {
		Usuario usuarioSalva = this.usuarioRepository.findById(codigo)
				.orElseThrow(()-> new EmptyResultDataAccessException(1));
		return usuarioSalva;
	}
}
