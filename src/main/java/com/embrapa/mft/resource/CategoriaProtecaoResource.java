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
import com.embrapa.mft.model.CadCategoriaProtecao;
import com.embrapa.mft.repository.CadCategoriaProtecaoRepository;
import com.embrapa.mft.repository.filter.CadCategoriaProtecaoFilter;
import com.embrapa.mft.service.CadCategoriaProtecaoService;

@RestController
@RequestMapping("/categoriaProtecao")
public class CategoriaProtecaoResource {
	
	@Autowired
	private CadCategoriaProtecaoRepository cadCategoriaProtecaoRepository;
	
	@Autowired
	private CadCategoriaProtecaoService cadCategoriaProtecaoService;
	
	@Autowired 
	private ApplicationEventPublisher EventPublisher;

	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_LISTAR_CATEGORIA') and #oauth2.hasScope('write')")
	public  Page<CadCategoriaProtecao> pesquisar(CadCategoriaProtecaoFilter cadCategoriaProtecaoFilter, Pageable pageable){
		return cadCategoriaProtecaoRepository.filtrar(cadCategoriaProtecaoFilter, pageable);
	}

	@PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
	public ResponseEntity<CadCategoriaProtecao> criar(@RequestBody CadCategoriaProtecao categoriaProtecao, HttpServletResponse response){
		CadCategoriaProtecao categoriaProtecaoSalva = cadCategoriaProtecaoRepository.save(categoriaProtecao);
		     EventPublisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaProtecaoSalva.getCdCategoriaProtecao()));
		      return ResponseEntity.status(HttpStatus.CREATED).body(categoriaProtecaoSalva);
	}
	
	
	@GetMapping("/{cdCategoriaProtecao}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public ResponseEntity<CadCategoriaProtecao> CategoriaProtecao_Buscar_Pelo_Id(@PathVariable Long cdCategoriaProtecao) {
		  CadCategoriaProtecao cadCategoriaProtecao = cadCategoriaProtecaoRepository.findOne(cdCategoriaProtecao);    
		    return cadCategoriaProtecao!= null ? ResponseEntity.ok(cadCategoriaProtecao) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cdCategoriaProtecao}")
    @PreAuthorize("hasAuthority('ROLE_REMOVER_CATEGORIA') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Remover(@PathVariable Long cdCategoriaProtecao) {
		cadCategoriaProtecaoRepository.delete(cdCategoriaProtecao);
	}
	
	  @PutMapping("/{cdCategoriaProtecao}")
	    @PreAuthorize("hasAuthority('ROLE_ATUALIZAR_CATEGORIA') and #oauth2.hasScope('write')")
	  public ResponseEntity<CadCategoriaProtecao> atualizar(@PathVariable Long cdCategoriaProtecao, @Valid @RequestBody CadCategoriaProtecao cadCategoriaProtecao){
		  CadCategoriaProtecao categoriaProtecaoSalva = cadCategoriaProtecaoService.atualizar(cdCategoriaProtecao, cadCategoriaProtecao);
		     return ResponseEntity.ok(categoriaProtecaoSalva);
		    		
	  }

}
