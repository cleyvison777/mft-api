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
import com.embrapa.mft.model.Genero;
import com.embrapa.mft.repository.CadGeneroRepository;


@RestController
@RequestMapping("/d02_genero")
public class CadGeneroResource {
	@Autowired
	private CadGeneroRepository mftGeneroRepository;
	
	@GetMapping
	public List<Genero> ListarGenero(){
		return mftGeneroRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Genero> criar (@RequestBody  Genero genero, HttpServletResponse response){
		Genero generoSalva = mftGeneroRepository.save(genero);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{d02_genero}").
				buildAndExpand(generoSalva.getCdGenero()).toUri();
		          response.setHeader("Location", uri.toASCIIString());
		            return ResponseEntity.created(uri).body(generoSalva);
	
	
          }
	
	@GetMapping("/{d02_genero}")
	   public Genero buscar_Genero_peloId(@PathVariable Long d02_genero) {
	        return mftGeneroRepository.findOne(d02_genero);	
	
      }
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void  Remover(@PathVariable Long ccodigo) {
		mftGeneroRepository.delete(ccodigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Genero> atualizar (@PathVariable Long codigo, @Valid @RequestBody Genero genero){
		Genero generoSalva = mftGeneroRepository.findOne(codigo);
		 BeanUtils.copyProperties(genero, generoSalva, "codigo");
		  mftGeneroRepository.save(generoSalva);
		   return ResponseEntity.ok(generoSalva);
	}
}
	
