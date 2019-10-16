package com.embrapa.mft.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.embrapa.mft.model.CategoriaProtecao;
import com.embrapa.mft.repository.MftCategoriaProtecaoRepository;

@RestController
@RequestMapping("/d09_categoria_protecao")
public class MftCategoriaProtecaoResouce {
	
	@Autowired
	private MftCategoriaProtecaoRepository mftCategoriaProtecaoRepository;
	
	@GetMapping
	public List<CategoriaProtecao> listarCategoriaProtecaos(){
		return mftCategoriaProtecaoRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<CategoriaProtecao> criar(@RequestBody CategoriaProtecao categoriaProtecao, HttpServletResponse response){
		CategoriaProtecao categoriaProtecaoSalva = mftCategoriaProtecaoRepository.save(categoriaProtecao);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{d09_categoria_protecao}")
				 .buildAndExpand(categoriaProtecaoSalva.getCdCategoriaProtecao()).toUri();
		            response.setHeader("Location", uri.toASCIIString());
		             return ResponseEntity.created(uri).body(categoriaProtecaoSalva);
	}
	
	
	@GetMapping("/{d09_categoria_protecao}")
	public CategoriaProtecao CategoriaProtecao_Buscar_Pelo_Id(@PathVariable Long d09_categoria_protecao) {
		return mftCategoriaProtecaoRepository.findOne(d09_categoria_protecao);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Remover(@PathVariable Long codigo) {
		mftCategoriaProtecaoRepository.delete(codigo);
	}
	
	  @PutMapping("/{codigo}")
	  public ResponseEntity<CategoriaProtecao> atualizar(@PathVariable Long codigo, @Valid @RequestBody CategoriaProtecao categoriaProtecao){
		  CategoriaProtecao categoriaProtecaoSalva = mftCategoriaProtecaoRepository.findOne(codigo);
		   BeanUtils.copyProperties(categoriaProtecao, categoriaProtecaoSalva, "codigo");
		    mftCategoriaProtecaoRepository.save(categoriaProtecaoSalva);
		     return ResponseEntity.ok(categoriaProtecaoSalva);
		    		
	  }

}
