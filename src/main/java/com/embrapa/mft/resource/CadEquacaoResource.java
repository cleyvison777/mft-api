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
import com.embrapa.mft.model.CadEquacao;
import com.embrapa.mft.repository.CadEquacaoRepository;

@RestController
@RequestMapping("/d08_equacao")
public class CadEquacaoResource {
@Autowired
 private CadEquacaoRepository mftEquacaoRepository;
	
 @GetMapping
   public List<CadEquacao> ListarEquacao(){
	  return mftEquacaoRepository.findAll();
	 }
 
  @PostMapping
  public ResponseEntity<CadEquacao> criar (@RequestBody CadEquacao cadEquacao, HttpServletResponse response){
	  CadEquacao cadEquacaoSalva = mftEquacaoRepository.save(cadEquacao);
	   URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{d08_equacao}").
			   buildAndExpand(cadEquacaoSalva.getCdEquacao()).toUri();
	      response.setHeader("Location", uri.toASCIIString());
	      return ResponseEntity.created(uri).body(cadEquacaoSalva);
  }
  
  @GetMapping("/{d08_cdequacao}")
   public CadEquacao buscar_equacao_peloId(@PathVariable Long d08_cdequacao) {
	  return mftEquacaoRepository.findOne(d08_cdequacao);
	  
     }
  
   @DeleteMapping("/{codigo}") 
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void Remover(@PathVariable Long codigo) {
	 mftEquacaoRepository.delete(codigo);
	 
    }
   
   @PutMapping("/{codigo}")
   public ResponseEntity<CadEquacao> atualizar (@PathVariable Long codigo, @Valid @RequestBody CadEquacao cadEquacao){
	   CadEquacao cadEquacaoSalva = mftEquacaoRepository.findOne(codigo);
	   BeanUtils.copyProperties(cadEquacao, cadEquacaoSalva, "codigo");
	    mftEquacaoRepository.save(cadEquacaoSalva);
	     return ResponseEntity.ok(cadEquacaoSalva);
   }
 
}


 

