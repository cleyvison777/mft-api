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
import com.embrapa.mft.model.CadFamilia;
import com.embrapa.mft.repository.CadFamiliaRepository;
import com.embrapa.mft.repository.filter.CadFamiliaFilter;
import com.embrapa.mft.service.CadFamiliaService;


@RestController
@RequestMapping("/cadfamilia")
public class CadFamiliaResource {
	
	@Autowired
	private CadFamiliaRepository  cadFamiliaRepository;
	
	@Autowired
	private CadFamiliaService cadFamiliaService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_FAMILIA') and #oauth2.hasScope('write')")
	public Page<CadFamilia> pesquisar(CadFamiliaFilter cadFamiliaFilter, Pageable pageable){
    	return cadFamiliaRepository.filtrar(cadFamiliaFilter, pageable);
    	

	}
    // Inserir_dados_na_tabela
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_FAMILIA') and #oauth2.hasScope('write')")
   public ResponseEntity<CadFamilia> criar(@RequestBody CadFamilia cadFamilia, HttpServletResponse response){
    	CadFamilia cadFamiliaSalva = cadFamiliaRepository.save(cadFamilia);
    	 eventPublisher.publishEvent(new RecursoCriadoEvent(this, response, cadFamiliaSalva.getCdFamilia()));
    	 
    	return ResponseEntity.status(HttpStatus.CREATED).body(cadFamiliaSalva);
    }
    
   // Buscar_culuna_especifica
    
    @GetMapping("/{cdFamilia}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_FAMILIA') and #oauth2.hasScope('read')")
    public ResponseEntity<CadFamilia> CadFamilia_Buscar_Pelo_Id(@PathVariable Long cdFamilia){
    	CadFamilia cadFamilia= cadFamiliaRepository.findOne(cdFamilia);
    	  return cadFamilia != null ? ResponseEntity.ok(cadFamilia) : ResponseEntity.notFound().build();
    }
  //deleta_Id_especifica

    @DeleteMapping("/{cdfamilia}")
    @PreAuthorize("hasAuthority('ROLE_REMOVER_FAMILIA') and #oauth2.hasScope('write')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
     public void Remover(@PathVariable Long cdfamilia) {
    	cadFamiliaRepository.delete(cdfamilia);
    }

    @PutMapping("/{cdFamilia}")
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_FAMILIA') and #oauth2.hasScope('write')")
     public ResponseEntity<CadFamilia> atualizar(@PathVariable Long cdFamilia, @Valid @RequestBody CadFamilia cadFamilia){
    	 CadFamilia cadFamiliaSalva = cadFamiliaService.atualizar(cdFamilia, cadFamilia);
    	    return ResponseEntity.ok(cadFamiliaSalva);
    }
    
    
}