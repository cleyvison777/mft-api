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
import com.embrapa.mft.model.CadTipoParcela;
import com.embrapa.mft.repository.CadTipoParcelaRepository;
import com.embrapa.mft.repository.filter.CadTipoParcelaFilter;
import com.embrapa.mft.service.CadTipoParcelaService;

@RestController
@RequestMapping("/cadtipoparcela")
public class CadTipoParcelaResource {

	@Autowired
	private CadTipoParcelaRepository cadTipoParcelaRepository;
	
	@Autowired
	private CadTipoParcelaService cadTipoParcelaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_TIPOPARCELA') and #oauth2.hasScope('read')")
	public Page<CadTipoParcela> pesquisar (CadTipoParcelaFilter cadTipoParcelaFilter, Pageable pageable){
		return cadTipoParcelaRepository.filtrar(cadTipoParcelaFilter, pageable);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TIPOPARCELA') and #oauth2.hasScope('write')")
	public ResponseEntity<CadTipoParcela> criar(@RequestBody CadTipoParcela cadTipoParcela, HttpServletResponse response){
		CadTipoParcela cadTipoParcelaSalva = cadTipoParcelaRepository.save(cadTipoParcela);
		  publisher.publishEvent(new RecursoCriadoEvent(this, response, cadTipoParcelaSalva.getCdTipoParcela()));
		
		  return ResponseEntity.status(HttpStatus.CREATED).body(cadTipoParcelaSalva);
	}
	
	@GetMapping("/{cdTipoParcela}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_TIPOPARCELA') and #oauth2.hasScope('read')")
    public ResponseEntity<CadTipoParcela>buscarPeloCodigo(@PathVariable Long cdTipoParcela){
		CadTipoParcela cadTipoParcela = cadTipoParcelaRepository.findOne(cdTipoParcela);
		   return cadTipoParcela != null ? ResponseEntity.ok(cadTipoParcela) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cdTipoParcela}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_TIPOPARCELA') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cdTipoParcela) {
		cadTipoParcelaRepository.delete(cdTipoParcela);
	}
	
	@PutMapping("/{cdTipoParcela}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_TIPOPARCELA') and #oauth2.hasScope('write')")
    public ResponseEntity<CadTipoParcela> atualizar(@PathVariable Long cdTipoParcela, @Valid @RequestBody CadTipoParcela cadTipoParcela){
		CadTipoParcela cadTipoParcelaSalva = cadTipoParcelaService.atualizar(cdTipoParcela, cadTipoParcela);
		 return ResponseEntity.ok(cadTipoParcelaSalva);
	}
}
