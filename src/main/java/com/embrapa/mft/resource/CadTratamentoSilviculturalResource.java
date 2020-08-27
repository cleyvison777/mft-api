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
import com.embrapa.mft.model.CadTratamentoSilvicultural;
import com.embrapa.mft.repository.CadTratamentoSilviculturalRepository;
import com.embrapa.mft.repository.filter.CadTratamentoSilviculturalFilter;
import com.embrapa.mft.service.CadTratamentoSilviculturalService;



@RestController
@RequestMapping("/cadtratamentosilvicultural")
public class CadTratamentoSilviculturalResource {
	
	@Autowired
	private CadTratamentoSilviculturalRepository cadTratamentoSilviculturalRepository;
	
	@Autowired
	private CadTratamentoSilviculturalService cadTratamentoSilviculturalService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CadTratamentoSilvicultural') and #oauth2.hasScope('read')")
    public Page<CadTratamentoSilvicultural> pesquisar(CadTratamentoSilviculturalFilter cadTratamentoSilviculturalFilter, Pageable pageable)	{
		return cadTratamentoSilviculturalRepository.filtrar(cadTratamentoSilviculturalFilter, pageable);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_AMF') and #oauth2.hasScope('write')")
    public ResponseEntity<CadTratamentoSilvicultural> criar(@RequestBody CadTratamentoSilvicultural cadTratamentoSilvicultural, HttpServletResponse response){
		CadTratamentoSilvicultural cadTratamentoSilviculturalSalva = cadTratamentoSilviculturalRepository.save(cadTratamentoSilvicultural);
		eventPublisher.publishEvent(new RecursoCriadoEvent(this, response, cadTratamentoSilviculturalSalva.getCdTratamento()));
		return ResponseEntity.status(HttpStatus.CREATED).body(cadTratamentoSilviculturalSalva);
	}
	
  
	@GetMapping("/{cdTratamento}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CadTratamentoSilvicultural') and #oauth2.hasScope('read')")
    public ResponseEntity<CadTratamentoSilvicultural> TratamentoSilvicultural_Buscar_Pelo_Id(@PathVariable Long cdTratamento){
		CadTratamentoSilvicultural cadTratamentoSilvicultural =cadTratamentoSilviculturalRepository.findOne(cdTratamento);
		 return cadTratamentoSilvicultural != null ? ResponseEntity.ok(cadTratamentoSilvicultural) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cdTratamento}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CadTratamentoSilvicultural'') and #oauth2.hasScope('write')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cdTratamento) {
		cadTratamentoSilviculturalRepository.delete(cdTratamento);
	}
	
	@PutMapping("/{cdTratamento}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_CadTratamentoSilvicultural'') and #oauth2.hasScope('write')")
	public ResponseEntity<CadTratamentoSilvicultural>atualizar(@PathVariable Long cdTratamento, @Valid @RequestBody CadTratamentoSilvicultural cadTratamentoSilvicultural){
		CadTratamentoSilvicultural cadTratamentoSilviculturalSalva = cadTratamentoSilviculturalService.atualizar(cdTratamento, cadTratamentoSilvicultural);
		   return ResponseEntity.ok(cadTratamentoSilviculturalSalva);
	}

	
}
