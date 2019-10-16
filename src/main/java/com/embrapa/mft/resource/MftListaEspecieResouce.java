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
import com.embrapa.mft.model.ListaEspecie;
import com.embrapa.mft.repository.MftListaEspecieRepository;

@RestController
@RequestMapping("/d05_lista_especie")
public class MftListaEspecieResouce {
	@Autowired
	private MftListaEspecieRepository mftListaEspecieRepository;
	
	@GetMapping
	public List<ListaEspecie> ListarEspecie(){
		return mftListaEspecieRepository.findAll();
	}
	
	@PostMapping
	 public ResponseEntity<ListaEspecie> criar(@RequestBody ListaEspecie listaEspecie, HttpServletResponse response){
		ListaEspecie listaEspecieSalva = mftListaEspecieRepository.save(listaEspecie);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{d05_lista_especie}")
				 .buildAndExpand(listaEspecieSalva.getCdListaEsp()).toUri();
		          response.setHeader("Location", uri.toASCIIString());
		            return ResponseEntity.created(uri).body(listaEspecieSalva);
	}

	@GetMapping("/{d05_lista_especie}")
	public ListaEspecie ListaEspecie_Buscar_Pelo_Id(@PathVariable Long d05_lista_especie) {
		return mftListaEspecieRepository.findOne(d05_lista_especie);
	}
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	 public void Remover(@PathVariable Long codigo) {
		mftListaEspecieRepository.delete(codigo);
	}
	@PutMapping("/{codigo}")
	public ResponseEntity<ListaEspecie> atualizar(@PathVariable Long codigo, @Valid @RequestBody ListaEspecie listaEspecie){
		ListaEspecie listaEspecieSalva = mftListaEspecieRepository.findOne(codigo);
		 BeanUtils.copyProperties(listaEspecie, listaEspecieSalva, "Codigo");
		  mftListaEspecieRepository.save(listaEspecieSalva);
		   return ResponseEntity.ok(listaEspecieSalva);
		   
	}
}
