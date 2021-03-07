package com.embrapa.mft.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.embrapa.mft.event.RecursoCriadoEvent;
import com.embrapa.mft.model.CadSubParcela;
import com.embrapa.mft.repository.CadSubParcelaRepository;
import com.embrapa.mft.repository.filter.CadSubParcelaFilter;
import com.embrapa.mft.service.CadSubParcelaService;

@RestController
@RequestMapping("/cadsubparcela")
public class CadSubParcelaResource {
	
	@Autowired
	private CadSubParcelaRepository cadSubParcelaRepository;

	@Autowired
	private CadSubParcelaService cadSubParcelaService;
		
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_EMPRESA') and #oauth2.hasScope('read')")
	public Page<CadSubParcela> pesquisar(CadSubParcelaFilter cadSubParcelaFilter, Pageable pageable){
		return cadSubParcelaRepository.filtrar(cadSubParcelaFilter, pageable);
	}
	
		
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMPRESA') and #oauth2.hasScope('write')")
	public ResponseEntity<CadSubParcela> criar(@RequestBody CadSubParcela cadSubParcela, HttpServletResponse response) {
		CadSubParcela cadSubParcelaSalva = cadSubParcelaRepository.save(cadSubParcela);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cadSubParcelaSalva.getCdSubParcela()));
				
		return ResponseEntity.status(HttpStatus.CREATED).body(cadSubParcelaSalva);
	}
	
	@GetMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_EMPRESA') and #oauth2.hasScope('read')")
	public ResponseEntity <CadSubParcela>buscarPeloCodigo(@PathVariable Long cdEmpresa) {
		CadSubParcela cadSubParcela = cadSubParcelaRepository.findOne(cdEmpresa);
		 return cadSubParcela != null ? ResponseEntity.ok(cadSubParcela) : ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_EMPRESA') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cdEmpresa) {
		cadSubParcelaRepository.delete(cdEmpresa);
	}
	
	@PutMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMPRESA') and #oauth2.hasScope('write')")
	public ResponseEntity<CadSubParcela> atualizar(@PathVariable Long cdEmpresa, @Valid @RequestBody CadSubParcela cadSubParcela) {
		CadSubParcela cadSubParcelaSalva = cadSubParcelaService.atualizar(cdEmpresa, cadSubParcela);
		return ResponseEntity.ok(cadSubParcelaSalva);
	}

}
