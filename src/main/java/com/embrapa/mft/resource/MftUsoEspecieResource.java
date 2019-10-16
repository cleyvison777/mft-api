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

import com.embrapa.mft.model.UsoEspecie;
import com.embrapa.mft.repository.MftUsoEspecieRepository;

@RestController
@RequestMapping("/d07_uso_especie")
public class MftUsoEspecieResource {

	@Autowired
    private MftUsoEspecieRepository mftUsoEspecieRepository;
	
	 @GetMapping
	 public List<UsoEspecie> ListarUsoEspecie(){
		 return mftUsoEspecieRepository.findAll();
	 }
	 
	 @PostMapping
	 public ResponseEntity<UsoEspecie> criar (@RequestBody UsoEspecie usoEspecie, HttpServletResponse response){
		 UsoEspecie usoEspecieSalva = mftUsoEspecieRepository.save(usoEspecie);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{d07_uso_especie}").
				 buildAndExpand(usoEspecieSalva.getCdUso()).toUri();
		          response.setHeader("Location", uri.toASCIIString());
		          return ResponseEntity.created(uri).body(usoEspecieSalva);
	 }
	 
	 @GetMapping("/{d07_uso_especie}")
	  public UsoEspecie Buscar_UsoEspecie_peloId(@PathVariable Long d07_uso_especie) {
		 return mftUsoEspecieRepository.findOne(d07_uso_especie);
		 
	 }
	 
	 @DeleteMapping("/{codigo}")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public void Remover(@PathVariable Long codigo) {
		 mftUsoEspecieRepository.delete(codigo);
	 }
	 
	 @PutMapping("/{codigo}")
	 public ResponseEntity<UsoEspecie> atualizar(@PathVariable Long codigo, @Valid @RequestBody UsoEspecie usoEspecie){
		 UsoEspecie especieEspecieSalva = mftUsoEspecieRepository.findOne(codigo);
		  BeanUtils.copyProperties(usoEspecie, especieEspecieSalva, "codigo");
		   mftUsoEspecieRepository.save(especieEspecieSalva);
		    return ResponseEntity.ok(especieEspecieSalva);
		
	 }
	 
	 
}
