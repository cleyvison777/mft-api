package com.embrapa.mft.resource;

import javax.servlet.http.HttpServletResponse;

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
import com.embrapa.mft.model.CadClasseDeTamanho;
import com.embrapa.mft.repository.CadClasseDeTamanhoRepository;
import com.embrapa.mft.repository.filter.CadClasseDeTamanhoFilter;
import com.embrapa.mft.service.CadClasseDeTamanhoService;

@RestController
@RequestMapping("/classedetanho")
public class CadClasseDeTamanhoResource {
	
	@Autowired
	private CadClasseDeTamanhoRepository cadClasseDeTamanhoRepository;
	
	@Autowired
	private CadClasseDeTamanhoService cadClasseDeTamanhoService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ClassTamanhoIndividuo') and #oauth2.hasScope('read')")
    public Page<CadClasseDeTamanho> pesquisar(CadClasseDeTamanhoFilter cadClasseDeTamanhoFilter, Pageable pageable){
		return cadClasseDeTamanhoRepository.filtrar(cadClasseDeTamanhoFilter, pageable);
	}
	 
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ClassTamanhoIndividuo') and #oauth2.hasScope('write')")
	public ResponseEntity<CadClasseDeTamanho> criar(@RequestBody CadClasseDeTamanho cadClasseDeTamanho, HttpServletResponse response){
		CadClasseDeTamanho cadClasseDeTamanhoSalva = cadClasseDeTamanhoRepository.save(cadClasseDeTamanho);
		eventPublisher.publishEvent(new RecursoCriadoEvent(this, response, cadClasseDeTamanhoSalva.getCdClasseTamanho()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cadClasseDeTamanhoSalva);
	}
	
	
	@GetMapping("/{cdClasseTamanho}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ClassTamanhoIndividuo') and #oauth2.hasScope('read')")
	public ResponseEntity<CadClasseDeTamanho> ClassTamanhoIndividuo_buscar_pelo_id(@PathVariable Long cdClasseTamanho){
		CadClasseDeTamanho cadClasseDeTamanho = cadClasseDeTamanhoRepository.findOne(cdClasseTamanho);
	return cadClasseDeTamanho != null ? ResponseEntity.ok(cadClasseDeTamanho) : ResponseEntity.notFound().build();
	}

  @DeleteMapping("/{cdClasseTamanho}")
  @PreAuthorize("hasAuthority('ROLE_REMOVER_ClassTamanhoIndividuo') and #oauth2.hasScope('write')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long cdClasseTamanho) {
	  cadClasseDeTamanhoRepository.delete(cdClasseTamanho);
  }
   
  @PutMapping("/{cdClasseTamanho}")
  @PreAuthorize("hasAuthority('ROLE_CADASTRAR_ClassTamanhoIndividuo') and #oauth2.hasScope('write')")
	public ResponseEntity<CadClasseDeTamanho> atualizar(@PathVariable Long cdClasseTamanho, @RequestBody CadClasseDeTamanho cadClasseDeTamanho){
	  CadClasseDeTamanho cadClasseDeTamanhoSalva = cadClasseDeTamanhoService.atualizar(cdClasseTamanho, cadClasseDeTamanho);
	    return ResponseEntity.ok(cadClasseDeTamanhoSalva);
  }

}
