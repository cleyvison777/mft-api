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

import com.embrapa.mft.model.SubParcelaMft;
import com.embrapa.mft.repository.CadSubParcelaRepository;


@RestController
@RequestMapping("/{d29_subparcela}")
public class CadSubParcelaResource {
	@Autowired
	private CadSubParcelaRepository mftSubParcelaRepository;
	
	@GetMapping
    public List<SubParcelaMft> ListarSubParcela(){
		return mftSubParcelaRepository.findAll();
}
	
	@PostMapping
	 public ResponseEntity<SubParcelaMft> criar (@RequestBody SubParcelaMft subParcelaMft, HttpServletResponse response){
		SubParcelaMft subParcelaMftSalva = mftSubParcelaRepository.save(subParcelaMft);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{d29_subparcela}")
				 .buildAndExpand(subParcelaMftSalva.getCdSubparcela()).toUri();
		            response.setHeader("Location", uri.toASCIIString());
		             return ResponseEntity.created(uri).body(subParcelaMftSalva);
	} 
	
	@PutMapping("/{codigo}")
	 public ResponseEntity<SubParcelaMft> atualizar(@PathVariable Long codigo, @Valid @RequestBody SubParcelaMft subParcelaMft){
		SubParcelaMft subParcelaMftSalva = mftSubParcelaRepository.findOne(codigo);
		 BeanUtils.copyProperties(subParcelaMft, subParcelaMftSalva, "codigo");
		  mftSubParcelaRepository.save(subParcelaMftSalva);
		   return ResponseEntity.ok(subParcelaMftSalva);
	}
	
	//Buscar_o_id_especifica
	@GetMapping("/{d29_subparcela}")
	public SubParcelaMft Buscar_SubParcelo_PeloID(@PathVariable Long d29_subparcela) {
		return mftSubParcelaRepository.findOne(d29_subparcela);
	 }
	
	   @DeleteMapping("/{codigo}")
	   @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void remover(@PathVariable Long codigo) {
		   mftSubParcelaRepository.delete(codigo);
	   }

	
}
