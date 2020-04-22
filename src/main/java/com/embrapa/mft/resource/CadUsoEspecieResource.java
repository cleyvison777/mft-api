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
import com.embrapa.mft.model.UsoEspecie;
import com.embrapa.mft.repository.CadUsoEspecieRepository;
import com.embrapa.mft.repository.filter.CadUsoEspecieFilter;
import com.embrapa.mft.service.cadUsoEspecieService;

@RestController
@RequestMapping("/usoespecie")
public class CadUsoEspecieResource {

	@Autowired
	private cadUsoEspecieService usoEspecieService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
    private CadUsoEspecieRepository mftUsoEspecieRepository;
	
	 @GetMapping
	 @PreAuthorize("hasAuthority('ROLE_PESQUISAR_USOESPECIE') and #oauth2.hasScope('read')")
	public Page<UsoEspecie> pesquisar(CadUsoEspecieFilter cadUsoEspecieFilter, Pageable pageable){
		 return mftUsoEspecieRepository.filtrar(cadUsoEspecieFilter, pageable);
	 }
	
	 @PostMapping
	 @PreAuthorize("hasAuthority('ROLE_CADASTRAR_usoEspecie') and #oauth2.hasScope('write')")
	 public ResponseEntity<UsoEspecie> criar (@RequestBody UsoEspecie usoEspecie, HttpServletResponse response){
		 UsoEspecie usoEspecieSalva = mftUsoEspecieRepository.save(usoEspecie);
		  eventPublisher.publishEvent(new RecursoCriadoEvent(this, response, usoEspecieSalva.getCdUso()));
		    return ResponseEntity.status(HttpStatus.CREATED).body(usoEspecieSalva);
		    
	 }
	 
	 @GetMapping("/{cduso}")
	 @PreAuthorize("hasAuthority('ROLE_PESQUISAR_usoEspecie') and #oauth2.hasScope('read')")
	  public ResponseEntity<UsoEspecie> Buscar_UsoEspecie_peloId(@PathVariable Long cduso) {
		 UsoEspecie usoEspecie =  mftUsoEspecieRepository.findOne(cduso);
		  return usoEspecie != null ? ResponseEntity.ok(usoEspecie) : ResponseEntity.notFound().build();
		 
	 }
	 
	 @DeleteMapping("/{cduso}")
	 @PreAuthorize("hasAuthority('ROLE_REMOVER_usoEspecie') and #oauth2.hasScope('write')")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public void Remover(@PathVariable Long cduso) {
		 mftUsoEspecieRepository.delete(cduso);
	 }
	 
	 @PutMapping("/{cduso}")
	 @PreAuthorize("hasAuthority('ROLE_CADASTRAR_usoEspecie') and #oauth2.hasScope('write')")
	 public ResponseEntity<UsoEspecie> atualizar(@PathVariable Long cduso, @Valid @RequestBody UsoEspecie usoEspecie){
		   UsoEspecie usoEspecieSalva = usoEspecieService.atualizar(cduso, usoEspecie);
		    return ResponseEntity.ok(usoEspecieSalva);
		
	 }
	 
	 
}
