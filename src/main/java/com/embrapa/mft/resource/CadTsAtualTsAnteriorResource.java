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
import com.embrapa.mft.model.CadTsAtualTsAnterior;
import com.embrapa.mft.repository.CadTsAtualTsAnteriorRepository;
import com.embrapa.mft.repository.filter.CadTsAtualTsAnteriorFilter;
import com.embrapa.mft.service.CadTsAtualTsAnteriorService;

@RestController
@RequestMapping("/cadtsatualtsanterior")
public class CadTsAtualTsAnteriorResource {
  
	@Autowired
	private CadTsAtualTsAnteriorRepository cadTsAtualTsAnteriorRepository;
	
	@Autowired
	private CadTsAtualTsAnteriorService cadTsAtualTsAnteriorService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_LISTAR_TS') and #oauth2.hasScope('write')")
    public Page<CadTsAtualTsAnterior> pesquisar(CadTsAtualTsAnteriorFilter cadTsAtualTsAnteriorFilter, Pageable pageable) {
		return cadTsAtualTsAnteriorRepository.filtrar(cadTsAtualTsAnteriorFilter, pageable);
	}
	
	@GetMapping("/{cdTratamentAnterior}")
	@PreAuthorize("hasAuthority('ROLE_LISTAR_TS') and #oauth2.hasScope('write')")
    public ResponseEntity<CadTsAtualTsAnterior>CadTsAtualTsAnterior_Buscar_Pelo_Id(@PathVariable Long cdTratamentAnterior){
		CadTsAtualTsAnterior cadTsAtualTsAnterior = cadTsAtualTsAnteriorRepository.findOne(cdTratamentAnterior);
				return cadTsAtualTsAnterior != null ? ResponseEntity.ok(cadTsAtualTsAnterior) : ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TS') and #oauth2.hasScope('write')")
    	public ResponseEntity<CadTsAtualTsAnterior> criar(@RequestBody CadTsAtualTsAnterior cadTsAtualTsAnterior, HttpServletResponse response){
		 CadTsAtualTsAnterior cadTsAtualTsAnteriorSalva = cadTsAtualTsAnteriorRepository.save(cadTsAtualTsAnterior);
		  eventPublisher.publishEvent(new RecursoCriadoEvent(this, response, cadTsAtualTsAnteriorSalva.getCdTratamentoAnteriorPk()));
		  
		  return ResponseEntity.status(HttpStatus.CREATED).body(cadTsAtualTsAnteriorSalva);
	}
	
	
	@DeleteMapping("/{cdTratamentoAnteriorPk}")
	@PreAuthorize("hasAuthority('ROLE_DELETAR_TS') and #oauth2.hasScope('write')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cdTratamentoAnteriorPk) {
		cadTsAtualTsAnteriorRepository.delete(cdTratamentoAnteriorPk);
	}
	
	
	@PutMapping("/{cdTratamentoAnteriorPk}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_TS') and #oauth2.hasScope('write')")
	 public ResponseEntity<CadTsAtualTsAnterior> atualizar(@PathVariable Long cdTratamentoAnteriorPk, @Valid @RequestBody CadTsAtualTsAnterior cadTsAtualTsAnterior){
		 CadTsAtualTsAnterior cadTsAtualTsAnteriorSalva = cadTsAtualTsAnteriorService.atualizar(cdTratamentoAnteriorPk, cadTsAtualTsAnterior);
		  return ResponseEntity.ok(cadTsAtualTsAnteriorSalva);
	}
}
