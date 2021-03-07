package com.embrapa.mft.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import com.embrapa.mft.model.CadEmpresa;
import com.embrapa.mft.model.CadUsoEspecie;
import com.embrapa.mft.repository.CadEmpresaRepository;
import com.embrapa.mft.repository.CadUsoEspecieRepository;
import com.embrapa.mft.repository.filter.CadEmpresaFilter;
import com.embrapa.mft.service.CadEmpresaService;


@RestController
@RequestMapping("/cadempresa")
public class CadEmpresaResource {
	
	@Autowired
	private CadEmpresaRepository cadEmpresaRepository;

	@Autowired
	private CadEmpresaService cadEmpresaService;
	
	@Autowired
	private CadUsoEspecieResource cadUsoEspecieResource; 
	
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_EMPRESA') and #oauth2.hasScope('read')")
	public Page<CadEmpresa> pesquisar(CadEmpresaFilter cadEmpresaFilter, Pageable pageable){
		return cadEmpresaRepository.filtrar(cadEmpresaFilter, pageable);
	}
	
		
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMPRESA') and #oauth2.hasScope('write')")
	public ResponseEntity<CadEmpresa> criar(@RequestBody CadEmpresa cadEmpresa, HttpServletResponse response) {
		CadEmpresa cadEmpresaSalva = cadEmpresaRepository.save(cadEmpresa);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cadEmpresaSalva.getCdEmpresa()));
				
		cadUsoEspecieResource.populaUsoEspecie(cadEmpresaSalva.getCdEmpresa());	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cadEmpresaSalva);
	}
	
	@GetMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_EMPRESA') and #oauth2.hasScope('read')")
	public ResponseEntity <CadEmpresa>buscarPeloCodigo(@PathVariable Long cdEmpresa) {
		CadEmpresa cadEmpresa = cadEmpresaRepository.findOne(cdEmpresa);
		 return cadEmpresa != null ? ResponseEntity.ok(cadEmpresa) : ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_EMPRESA') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cdEmpresa) {
		cadEmpresaRepository.delete(cdEmpresa);
	}
	
	@PutMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMPRESA') and #oauth2.hasScope('write')")
	public ResponseEntity<CadEmpresa> atualizar(@PathVariable Long cdEmpresa, @Valid @RequestBody CadEmpresa cadEmpresa) {
		CadEmpresa cadEmpresaSalva = cadEmpresaService.atualizar(cdEmpresa, cadEmpresa);
		return ResponseEntity.ok(cadEmpresaSalva);
	}
	
	
	
	

}
