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
import com.embrapa.mft.model.TipoParcelaMft;
import com.embrapa.mft.repository.MftTipoParcelaRepository;

@RestController
@RequestMapping("/d22_tipo_parcela")
public class MftTipoParcelaResource {

	@Autowired
	private MftTipoParcelaRepository mftTipoParcelaRepository;
	
	@GetMapping
	public List<TipoParcelaMft> ListarTipoParcela(){
		return mftTipoParcelaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<TipoParcelaMft> criar (@RequestBody TipoParcelaMft tipoParcelaMft, HttpServletResponse response){
		TipoParcelaMft tipoParcelaMftSalva = mftTipoParcelaRepository.save(tipoParcelaMft);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{d22_tipo_parcela}").
				buildAndExpand(tipoParcelaMftSalva.getCdTipoparcela()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(tipoParcelaMftSalva);
	
	       
}
	
@GetMapping("/{d22_cdtipoparcela}")
 public TipoParcelaMft Buscar_Tipo_ParcelaId(@PathVariable Long d22_cdtipoparcela) {
	return mftTipoParcelaRepository.findOne(d22_cdtipoparcela);
}


 @DeleteMapping("/{codigo}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
  public void Remover(@PathVariable Long codigo) {
	 mftTipoParcelaRepository.delete(codigo);
      }
 
 @PutMapping("/{codigo}")
  public ResponseEntity<TipoParcelaMft> atualizar (@PathVariable Long codigo, @Valid @RequestBody TipoParcelaMft tipoParcelaMft){
	  TipoParcelaMft tipoParcelaMftSalva = mftTipoParcelaRepository.findOne(codigo);
	   BeanUtils.copyProperties(tipoParcelaMft, tipoParcelaMftSalva, "codigo");
	    mftTipoParcelaRepository.save(tipoParcelaMftSalva);
	     return ResponseEntity.ok(tipoParcelaMftSalva);
 }

}
