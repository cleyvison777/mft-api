package com.embrapa.mft.resource;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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
	public ResponseEntity<CadCategoriaProtecao> criar(@RequestBody CadCategoriaProtecao categoriaProtecao, HttpServletResponse response){
		CadCategoriaProtecao categoriaProtecaoSalva = cadCategoriaProtecaoRepository.save(categoriaProtecao);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{d09_categoria_protecao}")
				 .buildAndExpand(categoriaProtecaoSalva.getCdCategoriaProtecao()).toUri();
		            response.setHeader("Location", uri.toASCIIString());
		             return ResponseEntity.created(uri).body(categoriaProtecaoSalva);
	}
	
	
	@GetMapping("/{d09_categoria_protecao}")
	public CadCategoriaProtecao CategoriaProtecao_Buscar_Pelo_Id(@PathVariable Long d09_categoria_protecao) {
		return cadCategoriaProtecaoRepository.findOne(d09_categoria_protecao);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Remover(@PathVariable Long codigo) {
		cadCategoriaProtecaoRepository.delete(codigo);
	}
	
	  @PutMapping("/{codigo}")
	  public ResponseEntity<CadCategoriaProtecao> atualizar(@PathVariable Long codigo, @Valid @RequestBody CadCategoriaProtecao categoriaProtecao){
		  CadCategoriaProtecao categoriaProtecaoSalva = cadCategoriaProtecaoRepository.findOne(codigo);
		   BeanUtils.copyProperties(categoriaProtecao, categoriaProtecaoSalva, "codigo");
		   cadCategoriaProtecaoRepository.save(categoriaProtecaoSalva);
		     return ResponseEntity.ok(categoriaProtecaoSalva);
		    		
	  }

}
