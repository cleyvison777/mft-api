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
import com.embrapa.mft.model.CadParcela;
import com.embrapa.mft.repository.CadParcelaRepository;
import com.embrapa.mft.repository.filter.CadParcelaFilter;
import com.embrapa.mft.service.CadParcelaService;

@RestController
@RequestMapping("/cadparcela")
public class CadParcelaResource {

	@Autowired
	private CadParcelaRepository cadParcelaRepository;

	@Autowired
	private CadParcelaService cadParcelaService;
	
	@Autowired
	private CadUsoEspecieResource cadUsoEspecieResource; 
	
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_EMPRESA') and #oauth2.hasScope('read')")
	public Page<CadParcela> pesquisar(CadParcelaFilter cadParcelaFilter, Pageable pageable){
		return cadParcelaRepository.filtrar(cadParcelaFilter, pageable);
	}
	
		
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMPRESA') and #oauth2.hasScope('write')")
	public ResponseEntity<CadParcela> criar(@RequestBody CadParcela cadParcela, HttpServletResponse response) {
		CadParcela cadParcelaSalva = cadParcelaRepository.save(cadParcela);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cadParcelaSalva.getCdParcela()));
				
		return ResponseEntity.status(HttpStatus.CREATED).body(cadParcelaSalva);
	}
	
	@GetMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_EMPRESA') and #oauth2.hasScope('read')")
	public ResponseEntity <CadParcela>buscarPeloCodigo(@PathVariable Long cdEmpresa) {
		CadParcela cadParcela = cadParcelaRepository.findOne(cdEmpresa);
		 return cadParcela != null ? ResponseEntity.ok(cadParcela) : ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_EMPRESA') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cdEmpresa) {
		cadParcelaRepository.delete(cdEmpresa);
	}
	
	@PutMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMPRESA') and #oauth2.hasScope('write')")
	public ResponseEntity<CadParcela> atualizar(@PathVariable Long cdEmpresa, @Valid @RequestBody CadParcela cadParcela) {
		CadParcela cadParcelaSalva = cadParcelaService.atualizar(cdEmpresa, cadParcela);
		return ResponseEntity.ok(cadParcelaSalva);
	}
	
	
}
