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
import com.embrapa.mft.model.CadAmf;
import com.embrapa.mft.repository.CadAmfRepository;
import com.embrapa.mft.repository.filter.CadAmfFilter;
import com.embrapa.mft.service.CadAmfService;


@RestController
@RequestMapping("/cadamf")
public class CadAmfResource {
	
@Autowired	
private CadAmfRepository cadAmfRepository;

@Autowired
private CadAmfService cadAmfService;

@Autowired
private ApplicationEventPublisher eventPublisher;

@GetMapping
@PreAuthorize("hasAuthority('ROLE_PESQUISAR_AMF') and #oauth2.hasScope('read')")
public Page<CadAmf> pesquisar(CadAmfFilter cadAmfFilter, Pageable pageable){
	return cadAmfRepository.filtrar(cadAmfFilter, pageable);
}

@PostMapping
@PreAuthorize("hasAuthority('ROLE_CADASTRAR_AMF') and #oauth2.hasScope('write')")
 public ResponseEntity<CadAmf> criar(@RequestBody CadAmf cadAmf, HttpServletResponse response){
	CadAmf cadAmfSalva =  cadAmfRepository.save(cadAmf);
	 eventPublisher.publishEvent(new RecursoCriadoEvent(this, response, cadAmfSalva.getCdarea()));
	 
	  return ResponseEntity.status(HttpStatus.CREATED).body(cadAmfSalva);
}


@GetMapping("/{cdarea}")
@PreAuthorize("hasAuthority('ROLE_PESQUISAR_AMF') and #oauth2.hasScope('read')")
 public ResponseEntity<CadAmf>CadAmf_Buscar_Pelo_Id(@PathVariable Long cdarea){
	CadAmf cadAmf =  cadAmfRepository.findOne(cdarea);
	 return cadAmf != null ? ResponseEntity.ok(cadAmf) : ResponseEntity.notFound().build();
	 
}

  @DeleteMapping("/{cdarea}")
  @PreAuthorize("hasAuthority('ROLE_REMOVER_AMF') and #oauth2.hasScope('write')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
      public void remover(@PathVariable Long cdarea) {
	  cadAmfRepository.delete(cdarea);
  }
  
   @PutMapping("/{cdarea}")
   @PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMPRESA') and #oauth2.hasScope('write')")
   public ResponseEntity<CadAmf> atualizar(@PathVariable Long cdarea, @Valid @RequestBody CadAmf cadAmf){
	   CadAmf cadAmfSalva = cadAmfService.atualizar(cdarea, cadAmf);
	     return ResponseEntity.ok(cadAmfSalva);
   }
  
 

}
