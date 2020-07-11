package com.embrapa.mft.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.embrapa.mft.model.CadTsAtualTsAnterior;
import com.embrapa.mft.repository.CadTsAtualTsAnteriorRepository;
import com.embrapa.mft.repository.filter.CadTsAtualTsAnteriorFilter;
import com.embrapa.mft.service.CadTsAtualTsAnteriorService;

@RestController
@RequestMapping("/cadtsatualtsanterior")
public class CadTsAtualTsAnteriorResource {
  
	@Autowired
	private CadTsAtualTsAnteriorRepository cadTsAtualTsAnteriorRepository;
	
	@Autowired
	private CadTsAtualTsAnteriorService cadTsAtualTsAnteriorService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_LISTAR_TS') and #oauth2.hasScope('write')")
    public Page<CadTsAtualTsAnterior> pesquisar(CadTsAtualTsAnteriorFilter cadTsAtualTsAnteriorFilter, Pageable pageable) {
		return cadTsAtualTsAnteriorRepository.filtrar(cadTsAtualTsAnteriorFilter, pageable);
	}
	
	
	
	
	
}
