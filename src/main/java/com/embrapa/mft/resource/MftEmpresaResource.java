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
import com.embrapa.mft.model.CadEmpresa;
import com.embrapa.mft.repository.MftRepository;


@RestController
@RequestMapping("/d13_empresa")
public class MftEmpresaResource {
	@Autowired
	private MftRepository mftRepository;
	//Bucasca_tabela *
	@GetMapping
public List<CadEmpresa> listar(){
	return mftRepository.findAll();
	
   }
	//insere_tabela *
@PostMapping
public ResponseEntity<CadEmpresa> criar(@RequestBody CadEmpresa cadEmpresa, HttpServletResponse response) {
	CadEmpresa CadEmpresaSalva = mftRepository.save(cadEmpresa);
	 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{D13_cdempresa}")
    .buildAndExpand(CadEmpresaSalva.getCdEmpresa()).toUri();
     response.setHeader("Location", uri.toASCIIString());
     
     return ResponseEntity.created(uri).body(CadEmpresaSalva);
}
//Buscar_o_id_especifica
@GetMapping("/{D13_cdempresa}")
public CadEmpresa BuscarD13_empresaPeloID(@PathVariable Long D13_cdempresa) {
	return mftRepository.findOne(D13_cdempresa);
 }

//deleta_Id_especifica
@DeleteMapping("/{codigo}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void Remover(@PathVariable Long codigo) {
	mftRepository.delete(codigo);
       }

@PutMapping("/{codigo}")
 public ResponseEntity<CadEmpresa> atualizar(@PathVariable Long codigo, @Valid @RequestBody CadEmpresa cadEmpresa){
	CadEmpresa cadEmpresaSalva = mftRepository.findOne(codigo);
	BeanUtils.copyProperties(cadEmpresa, cadEmpresaSalva, "codigo");
	 mftRepository.save(cadEmpresaSalva);
	  return ResponseEntity.ok(cadEmpresaSalva);
    }



}
