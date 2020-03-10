package com.embrapa.mft.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	 private CadGrupoEcologicoService cadGrupoEcologicoResource;
	

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
	  
	  @GetMapping("/{d06_grupo_ecologico}")
	   public CadGrupoEcologico buscar_GrupoEcologico_peloId(@PathVariable Long d06_grupo_ecologico) {
		  return cadGrupoEcologicoRepository.findOne(d06_grupo_ecologico);
		  
	  }
	  
	  @DeleteMapping("/{codigo}") 
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void Remover(@PathVariable Long codigo) {
		  cadGrupoEcologicoRepository.delete(codigo);
	  }
	  
	 @PutMapping("/{codigo}")
	 public ResponseEntity<CadGrupoEcologico> atualizar(@PathVariable Long codigo, @Valid @RequestBody CadGrupoEcologico cadGrupoEcologico){
		 CadGrupoEcologico cadGrupoEcologicoSalva = cadGrupoEcologicoRepository.findOne(codigo);
		  BeanUtils.copyProperties(cadGrupoEcologico, cadGrupoEcologicoSalva, "codigo");
		  cadGrupoEcologicoRepository.save(cadGrupoEcologicoSalva);
		    return ResponseEntity.ok(cadGrupoEcologicoSalva);
	 }
	  
	  
}
