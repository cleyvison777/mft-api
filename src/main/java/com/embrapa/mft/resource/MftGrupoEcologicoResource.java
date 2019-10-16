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
import com.embrapa.mft.model.CadGrupoEcologico;
import com.embrapa.mft.repository.MftGrupoEcologicoRepository;

@RestController
@RequestMapping("/d06_grupo_ecologico")
public class MftGrupoEcologicoResource {

	 @Autowired
	 private MftGrupoEcologicoRepository mftGrupoEcologicoRepository;
	  
	  @GetMapping 
	  public List<CadGrupoEcologico> ListarGrupoEcologico(){
		  return mftGrupoEcologicoRepository.findAll();
	  }
	  
	  @PostMapping
	  
	  public ResponseEntity<CadGrupoEcologico> criar (@RequestBody CadGrupoEcologico cadGrupoEcologico, HttpServletResponse response){
		  CadGrupoEcologico cadGrupoEcologicoSalva = mftGrupoEcologicoRepository.save(cadGrupoEcologico);
		   URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{d06_grupo_ecologico}").
				   buildAndExpand(cadGrupoEcologicoSalva.getCdGrupoEcologico()).toUri();
		   response.setHeader("Location", uri.toASCIIString());
		     return ResponseEntity.created(uri).body(cadGrupoEcologicoSalva);
				   
	  }
	  
	  @GetMapping("/{d06_grupo_ecologico}")
	   public CadGrupoEcologico buscar_GrupoEcologico_peloId(@PathVariable Long d06_grupo_ecologico) {
		  return mftGrupoEcologicoRepository.findOne(d06_grupo_ecologico);
		  
	  }
	  
	  @DeleteMapping("/{codigo}") 
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void Remover(@PathVariable Long codigo) {
	 	 mftGrupoEcologicoRepository.delete(codigo);
	  }
	  
	 @PutMapping("/{codigo}")
	 public ResponseEntity<CadGrupoEcologico> atualizar(@PathVariable Long codigo, @Valid @RequestBody CadGrupoEcologico cadGrupoEcologico){
		 CadGrupoEcologico cadGrupoEcologicoSalva = mftGrupoEcologicoRepository.findOne(codigo);
		  BeanUtils.copyProperties(cadGrupoEcologico, cadGrupoEcologicoSalva, "codigo");
		   mftGrupoEcologicoRepository.save(cadGrupoEcologicoSalva);
		    return ResponseEntity.ok(cadGrupoEcologicoSalva);
	 }
	  
	  
}
