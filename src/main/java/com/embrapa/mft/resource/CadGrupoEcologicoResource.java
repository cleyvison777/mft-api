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
import com.embrapa.mft.model.CadGrupoEcologico;
import com.embrapa.mft.repository.CadGrupoEcologicoRepository;
import com.embrapa.mft.repository.filter.CadGrupoEcologicoFilter;
import com.embrapa.mft.service.CadGrupoEcologicoService;

@RestController
@RequestMapping("/grupoecologico")
public class CadGrupoEcologicoResource {
	
	 @Autowired
	 private CadGrupoEcologicoRepository cadGrupoEcologicoRepository;
	
	@Autowired
	 private CadGrupoEcologicoService cadGrupoEcologicoService;
	

	@Autowired
	private ApplicationEventPublisher EventPublisher;
	  
	  @GetMapping 
	  @PreAuthorize("hasAuthority('ROLE_LISTAR_GRUPO_ECOLOGICO') and #oauth2.hasScope('write')")
	  public Page<CadGrupoEcologico> pesquisar(CadGrupoEcologicoFilter cadGrupoEcologicoFilter, Pageable pageable){
		  return cadGrupoEcologicoRepository.filtrar(cadGrupoEcologicoFilter, pageable);
	  }
	  
	  @PostMapping
	    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_GRUPO_ECOLOGICO') and #oauth2.hasScope('write')")

	  public ResponseEntity<CadGrupoEcologico> criar (@RequestBody CadGrupoEcologico cadGrupoEcologico, HttpServletResponse response){
		  CadGrupoEcologico cadGrupoEcologicoSalva = cadGrupoEcologicoRepository.save(cadGrupoEcologico);
		      EventPublisher.publishEvent(new RecursoCriadoEvent(this, response, cadGrupoEcologicoSalva.getCdGrupoEcologico()));
		     return ResponseEntity.status(HttpStatus.CREATED).body(cadGrupoEcologicoSalva);
				   
	  }
	  
	  @GetMapping("/{cdGrupoEcologico}")
	    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_GRUPO_ECOLOGICO') and #oauth2.hasScope('read')")
	    public ResponseEntity<CadGrupoEcologico> buscar_GrupoEcologico_peloId(@PathVariable Long cdGrupoEcologico) {
		  CadGrupoEcologico cadGrupoEcologico = cadGrupoEcologicoRepository.findOne(cdGrupoEcologico);
		    return cadGrupoEcologico != null ? ResponseEntity.ok(cadGrupoEcologico) : ResponseEntity.notFound().build();
		  
	  }
	  
	  @DeleteMapping("/{cdGrupoEcologico}") 
	  @PreAuthorize("hasAuthority('ROLE_REMOVER_GRUPO_ECOLOGICO') and #oauth2.hasScope('write')")
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void Remover(@PathVariable Long cdGrupoEcologico) {
		  cadGrupoEcologicoRepository.delete(cdGrupoEcologico);
	  }
	  
	 @PutMapping("/{cdGrupoEcologico}")
	  @PreAuthorize("hasAuthority('ROLE_ATUALIZAR_GRUPO_ECOLOGICO') and #oauth2.hasScope('write')")

	 public ResponseEntity<CadGrupoEcologico> atualizar(@PathVariable Long cdGrupoEcologico, @Valid @RequestBody CadGrupoEcologico cadGrupoEcologico){
		 CadGrupoEcologico cadGrupoEcologicoSalva = cadGrupoEcologicoService.atualiza(cdGrupoEcologico, cadGrupoEcologico);
		     return ResponseEntity.ok(cadGrupoEcologicoSalva);
	 }
	  
	  
}
