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
import com.embrapa.mft.model.ICClasseDeFloresta;
import com.embrapa.mft.repository.ICClasseDeFlorestaRepository;
import com.embrapa.mft.repository.filter.ICClasseDeFlorestaFilter;
import com.embrapa.mft.service.ICClasseDeFlorestaService;

@RestController
@RequestMapping("/icclasefloresta") 
public class ICClasseDeFlorestaResouce {
	
	@Autowired
	private ICClasseDeFlorestaRepository cadListaEspecieRepository;
	
	@Autowired
	private ICClasseDeFlorestaService iCClasseDeFlorestaService;
	
	
	@Autowired
	 private ApplicationEventPublisher publisher;
	
    @GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ESPECIE') and #oauth2.hasScope('read')")
	public Page<ICClasseDeFloresta> pesquisar(ICClasseDeFlorestaFilter iCClasseDeFlorestaFilter, Pageable pageable){ 
    	return cadListaEspecieRepository.filtrar(iCClasseDeFlorestaFilter, pageable); 
    }
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ESPECIE') and #oauth2.hasScope('write')")
	 public ResponseEntity<ICClasseDeFloresta> criar(@RequestBody ICClasseDeFloresta iCClasseDeFloresta, HttpServletResponse response){
		ICClasseDeFloresta iCClasseDeFlorestaSalva = cadListaEspecieRepository.save(iCClasseDeFloresta);
		   publisher.publishEvent(new RecursoCriadoEvent(this, response, iCClasseDeFlorestaSalva.getCdClassefloresta()));
		            return ResponseEntity.status(HttpStatus.CREATED).body(iCClasseDeFlorestaSalva);
	}

	@GetMapping("/{d05_lista_especie}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ESPECIE') and #oauth2.hasScope('read')")
	public ResponseEntity<ICClasseDeFloresta> ListaEspecie_Buscar_Pelo_Id(@PathVariable Long d05_lista_especie) {
		ICClasseDeFloresta iCClasseDeFloresta = cadListaEspecieRepository.findOne(d05_lista_especie);
		 return iCClasseDeFloresta != null ? ResponseEntity.ok(iCClasseDeFloresta) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cadListaEspecie}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_ESPECIE') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	 public void Remover(@PathVariable Long cadListaEspecie) {
		cadListaEspecieRepository.delete(cadListaEspecie);
	}
	
	
	@PutMapping("/{cadListaEspecie}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_ESPECIE') and #oauth2.hasScope('write')")
	public ResponseEntity<ICClasseDeFloresta> atualizar(@PathVariable Long codigo, @Valid @RequestBody ICClasseDeFloresta iCClasseDeFloresta){
		 ICClasseDeFloresta iCClasseDeFlorestaSalva = iCClasseDeFlorestaService.atualizar(codigo, iCClasseDeFloresta);
		   return ResponseEntity.ok(iCClasseDeFlorestaSalva);
		   
	}
	
	
	
}
