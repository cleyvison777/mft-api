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
import com.embrapa.mft.model.ParcelaMft;
import com.embrapa.mft.repository.MftParcelaRepository;

@RestController
@RequestMapping("/d21_parcela")
public class MftParcelaResource {

	@Autowired
	private MftParcelaRepository  mftParcelaRepository;
	
	@GetMapping
	 public List<ParcelaMft> ListarParcela(){
		return mftParcelaRepository.findAll();
	}
	
	@PostMapping
	  public ResponseEntity<ParcelaMft> criar (@RequestBody ParcelaMft parcelaMFT, HttpServletResponse response){
	   ParcelaMft ParselaSalvar = mftParcelaRepository.save(parcelaMFT);
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{d21_cdparcela}")
	    .buildAndExpand(ParselaSalvar.getCdParcela()).toUri();
	        response.setHeader("Location", uri.toASCIIString());
	          return ResponseEntity.created(uri).body(ParselaSalvar);
	}
	@GetMapping("/d21_cdparcela")
	 public ParcelaMft Buscar_parcelaId (@PathVariable Long d21_cdparcela) {
		return mftParcelaRepository.findOne(d21_cdparcela);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Remover (@PathVariable Long codigo) {
		mftParcelaRepository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
    public ResponseEntity<ParcelaMft> atualizar(@PathVariable Long codigo, @Valid @RequestBody ParcelaMft parcelaMft){
		ParcelaMft parcelaMftSalva = mftParcelaRepository.findOne(codigo);
		 BeanUtils.copyProperties(parcelaMft, parcelaMftSalva, "codigo");
		  mftParcelaRepository.save(parcelaMftSalva);
		   return ResponseEntity.ok(parcelaMftSalva);
	}
}
