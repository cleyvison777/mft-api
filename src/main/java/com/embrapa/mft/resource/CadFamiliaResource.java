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

import com.embrapa.mft.model.CadFamilia;
import com.embrapa.mft.repository.CadFamiliaRepository;


@RestController
@RequestMapping("/d01_familia")
public class CadFamiliaResource {
	@Autowired
	private CadFamiliaRepository  mftCadFamliaRepository;
	
    @GetMapping
	public List<CadFamilia> ListarFamilia(){
	 return mftCadFamliaRepository.findAll();

	}
    // Inserir_dados_na_tabela
    @PostMapping
   public ResponseEntity<CadFamilia> criar(@RequestBody CadFamilia cadFamilia, HttpServletResponse response){
    	CadFamilia cadFamiliaSalva = mftCadFamliaRepository.save(cadFamilia);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{D01_cdfamilia}")
    			.buildAndExpand(cadFamiliaSalva.getCdFamilia()).toUri();
    	        response.setHeader("Location", uri.toASCIIString());
    	return ResponseEntity.created(uri).body(cadFamiliaSalva);
    }
    
   // Buscar_culuna_especifica
    
    @GetMapping("/{D01_cdfamilia}")
    public CadFamilia BuscarCadFamiliaPeloID(@PathVariable Long D01_cdfamilia) {
    	return mftCadFamliaRepository.findOne(D01_cdfamilia);
     }
  //deleta_Id_especifica

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
     public void Remover(@PathVariable Long codigo) {
    	mftCadFamliaRepository.delete(codigo);
    }

    @PutMapping("/{codigo}")
     public ResponseEntity<CadFamilia> atualizar(@PathVariable Long codigo, @Valid @RequestBody CadFamilia cadFamilia){
    	CadFamilia cadFamiliaSalva = mftCadFamliaRepository.findOne(codigo);
    	 BeanUtils.copyProperties(cadFamilia, cadFamiliaSalva, "codigo");
    	  mftCadFamliaRepository.save(cadFamiliaSalva);
    	   return ResponseEntity.ok(cadFamiliaSalva);
    }
    
    
}