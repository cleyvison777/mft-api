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
import com.embrapa.mft.model.CadTipoParcela;
import com.embrapa.mft.repository.CadTipoParcelaRepository;

@RestController
@RequestMapping("/d22_tipo_parcela")
public class CadTipoParcelaResource {

	@Autowired
	private CadTipoParcelaRepository cadParcelaRepository;
	
	@GetMapping
	public List<CadTipoParcela> ListarTipoParcela(){
		return cadParcelaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<CadTipoParcela> criar (@RequestBody CadTipoParcela tipoParcelaMft, HttpServletResponse response){
		CadTipoParcela tipoParcelaMftSalva = cadParcelaRepository.save(tipoParcelaMft);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{d22_tipo_parcela}").
				buildAndExpand(tipoParcelaMftSalva.getCdTipoparcela()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(tipoParcelaMftSalva);
	
	       
}
	
@GetMapping("/{d22_cdtipoparcela}")
 public CadTipoParcela Buscar_Tipo_ParcelaId(@PathVariable Long d22_cdtipoparcela) {
	return cadParcelaRepository.findOne(d22_cdtipoparcela);
}


 @DeleteMapping("/{codigo}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
  public void Remover(@PathVariable Long codigo) {
	 cadParcelaRepository.delete(codigo);
      }
 
 @PutMapping("/{codigo}")
  public ResponseEntity<CadTipoParcela> atualizar (@PathVariable Long codigo, @Valid @RequestBody CadTipoParcela tipoParcelaMft){
	  CadTipoParcela tipoParcelaMftSalva = cadParcelaRepository.findOne(codigo);
	   BeanUtils.copyProperties(tipoParcelaMft, tipoParcelaMftSalva, "codigo");
	   cadParcelaRepository.save(tipoParcelaMftSalva);
	     return ResponseEntity.ok(tipoParcelaMftSalva);
 }

}
