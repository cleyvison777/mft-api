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
	 
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ClassTamanhoIndividuo') and #oauth2.hasScope('write')")
	public ResponseEntity<CadClassTamanhoIndividuo> criar(@RequestBody CadClassTamanhoIndividuo cadClassTamanhoIndividuo, HttpServletResponse response){
		CadClassTamanhoIndividuo cadClassTamanhoIndividuoSalva = cadClassTamanhoIndividuoRepository.save(cadClassTamanhoIndividuo);
		eventPublisher.publishEvent(new RecursoCriadoEvent(this, response, cadClassTamanhoIndividuoSalva.getCdClasseTamanho()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cadClassTamanhoIndividuoSalva);
	}
	
	
	@GetMapping("/{cdClasseTamanho}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ClassTamanhoIndividuo') and #oauth2.hasScope('read')")
	public ResponseEntity<CadClassTamanhoIndividuo> ClassTamanhoIndividuo_buscar_pelo_id(@PathVariable Long cdClasseTamanho){
		CadClassTamanhoIndividuo cadClassTamanhoIndividuo = cadClassTamanhoIndividuoRepository.findOne(cdClasseTamanho);
	return cadClassTamanhoIndividuo != null ? ResponseEntity.ok(cadClassTamanhoIndividuo) : ResponseEntity.notFound().build();
	}

  @DeleteMapping("/{cdClasseTamanho}")
  @PreAuthorize("hasAuthority('ROLE_REMOVER_ClassTamanhoIndividuo') and #oauth2.hasScope('write')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long cdClasseTamanho) {
	  cadClassTamanhoIndividuoRepository.delete(cdClasseTamanho);
  }
   
  @PutMapping("/{cdClasseTamanho}")
  @PreAuthorize("hasAuthority('ROLE_CADASTRAR_ClassTamanhoIndividuo') and #oauth2.hasScope('write')")
	public ResponseEntity<CadClassTamanhoIndividuo> atualizar(@PathVariable Long cdClasseTamanho, @RequestBody CadClassTamanhoIndividuo cadClassTamanhoIndividuo){
	  CadClassTamanhoIndividuo cadClassTamanhoIndividuoSalva = cadClassTamanhoIndividuoService.atualizar(cdClasseTamanho, cadClassTamanhoIndividuo);
	    return ResponseEntity.ok(cadClassTamanhoIndividuoSalva);
  }
	
}
