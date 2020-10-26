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
import com.embrapa.mft.model.CadListaEspecie;
import com.embrapa.mft.repository.CadListaEspecieRepository;
import com.embrapa.mft.repository.filter.CadListaEspecieFilter;
import com.embrapa.mft.service.CadListaEspecieService;

@RestController
@RequestMapping("/cadlistaespecie")

public class CadListaEspecieResouce {
	
	@Autowired
	private CadListaEspecieRepository cadListaEspecieRepository;
	
	@Autowired
	private CadListaEspecieService cadlistaEspecieService;
	
	
	@Autowired
	 private ApplicationEventPublisher publisher;
	
      @GetMapping
	  @PreAuthorize("hasAuthority('ROLE_PESQUISAR_ESPECIE') and #oauth2.hasScope('read')"
	  ) public Page<CadListaEspecie> pesquisar(CadListaEspecieFilter
	   listaEspecieFilter, Pageable pageable){ return
	   cadListaEspecieRepository.filtrar(listaEspecieFilter, pageable); }
	   
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ESPECIE') and #oauth2.hasScope('write')")
	 public ResponseEntity<CadListaEspecie> criar(@RequestBody CadListaEspecie listaEspecie, HttpServletResponse response){
		CadListaEspecie listaEspecieSalva = cadListaEspecieRepository.save(listaEspecie);
		   publisher.publishEvent(new RecursoCriadoEvent(this, response, listaEspecieSalva.getCdListaEsp()));
		            return ResponseEntity.status(HttpStatus.CREATED).body(listaEspecieSalva);
	}

	@GetMapping("/{d05_lista_especie}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ESPECIE') and #oauth2.hasScope('read')")
	public ResponseEntity<CadListaEspecie> ListaEspecie_Buscar_Pelo_Id(@PathVariable Long d05_lista_especie) {
		CadListaEspecie listaEspecie = cadListaEspecieRepository.findOne(d05_lista_especie);
		 return listaEspecie != null ? ResponseEntity.ok(listaEspecie) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cadListaEspecie}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_ESPECIE') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	 public void Remover(@PathVariable Long cadListaEspecie) {
		cadListaEspecieRepository.delete(cadListaEspecie);
	}
	
	
	@PutMapping("/{cadListaEspecie}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_ESPECIE') and #oauth2.hasScope('write')")
	public ResponseEntity<CadListaEspecie> atualizar(@PathVariable Long cadListaEspecie, @Valid @RequestBody CadListaEspecie listaEspecie){
		 CadListaEspecie listaEspecieSalva = cadlistaEspecieService.atualizar(cadListaEspecie, listaEspecie);
		   return ResponseEntity.ok(listaEspecieSalva);
		   
	}
	
	
	
}
