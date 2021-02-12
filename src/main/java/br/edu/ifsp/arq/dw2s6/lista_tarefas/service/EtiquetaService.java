package br.edu.ifsp.arq.dw2s6.lista_tarefas.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.lista_tarefas.domain.model.Etiqueta;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.repository.EtiquetaRepository;

@Service
public class EtiquetaService {
	
	@Autowired
	private EtiquetaRepository etiquetaRepository;
	
	public Etiqueta atualizar(Long codigo, Etiqueta etiqueta) {
		Etiqueta etiquetaSalva = buscarEtiquetaPeloCodigo(codigo);
		BeanUtils.copyProperties(etiqueta, etiquetaSalva, "codigo");
		return this.etiquetaRepository.save(etiquetaSalva);
	}
	
	private Etiqueta buscarEtiquetaPeloCodigo(Long codigo) {
		Etiqueta etiquetaSalva = this.etiquetaRepository.findById(codigo)
				.orElseThrow(()-> new EmptyResultDataAccessException(1));
		return etiquetaSalva;
	}
}
