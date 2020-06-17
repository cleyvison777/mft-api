package com.embrapa.mft.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.embrapa.mft.model.CadClassTamanhoIndividuo;
import com.embrapa.mft.repository.CadClassTamanhoIndividuoRepository;
import com.embrapa.mft.repository.filter.CadClassTamanhoIndividuoFilter;
import com.embrapa.mft.service.CadClassTamanhoIndividuoService;

@RestController
@RequestMapping("/classtamanhoindividuo")
public class CadClassTamanhoIndividuoResource {
	
	@Autowired
	private CadClassTamanhoIndividuoRepository cadClassTamanhoIndividuoRepository;
	
	@Autowired
	private CadClassTamanhoIndividuoService cadClassTamanhoIndividuoService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ClassTamanhoIndividuo') and #oauth2.hasScope('read')")
    public Page<CadClassTamanhoIndividuo> pesquisar(CadClassTamanhoIndividuoFilter cadClassTamanhoIndividuoFilter, Pageable pageable){
		return cadClassTamanhoIndividuoRepository.filtrar(cadClassTamanhoIndividuoFilter, pageable);
	}

}
