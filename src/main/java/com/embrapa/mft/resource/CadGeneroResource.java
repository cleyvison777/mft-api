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
import com.embrapa.mft.model.CadGenero;
import com.embrapa.mft.repository.CadGeneroRepository;
import com.embrapa.mft.repository.filter.CadGeneroFilter;
import com.embrapa.mft.service.CadGeneroService;


@RestController
@RequestMapping("/genero")
public class CadGeneroResource {
	@Autowired
	private CadGeneroRepository  cadGeneroRepository;
	
	@Autowired
	private CadGeneroService generoService;
	
	@Autowired
	private ApplicationEventPublisher EventPublisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_LISTAR_GENERO') and #oauth2.hasScope('write')")
	public Page<CadGenero> pesquisar(CadGeneroFilter cadGeneroFilter, Pageable pageable){
		return cadGeneroRepository.filtrar(cadGeneroFilter, pageable);
	}

	@PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_GENERO') and #oauth2.hasScope('write')")
	public ResponseEntity<CadGenero> criar (@RequestBody  CadGenero genero, HttpServletResponse response){
		CadGenero generoSalva = cadGeneroRepository.save(genero);
		 EventPublisher.publishEvent(new RecursoCriadoEvent(this, response, generoSalva.getCdGenero()));
	           return ResponseEntity.status(HttpStatus.CREATED).body(generoSalva);
          }
	   // Buscar_culuna_especifica
	@GetMapping("/{cdgenero}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_GENERO') and #oauth2.hasScope('read')")
	   public ResponseEntity<CadGenero> buscar_Genero_peloId(@PathVariable Long cdgenero) {
		  CadGenero genero = cadGeneroRepository.findOne(cdgenero);	
	        return genero != null ? ResponseEntity.ok(genero) : ResponseEntity.notFound().build();
	
      }
	@DeleteMapping("/{cdgenero}")
    @PreAuthorize("hasAuthority('ROLE_REMOVER_GENERO') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void  Remover(@PathVariable Long cdgenero) {
		cadGeneroRepository.delete(cdgenero);
	}
	
	
    // Inserir_dados_na_tabela
	@PutMapping("/{cdGenero}")
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_GENERO') and #oauth2.hasScope('write')")
	public ResponseEntity<CadGenero> atualizar (@PathVariable Long cdGenero, @Valid @RequestBody CadGenero genero){
		CadGenero generoSalva = generoService.atualizar(cdGenero, genero);
		   return ResponseEntity.ok(generoSalva);
	}
	

	
}
	
