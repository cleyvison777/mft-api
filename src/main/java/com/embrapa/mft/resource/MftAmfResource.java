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
import com.embrapa.mft.model.CadAmf;
import com.embrapa.mft.repository.MftcadAmfRepository;

@RestController
@RequestMapping("/d20_area")
public class MftAmfResource {
	 // listar_dados_na_tabela
@Autowired	
private MftcadAmfRepository mftcadAmfRepository;
 
@GetMapping
public List<CadAmf> ListarAmf(){
	return mftcadAmfRepository.findAll();
}


@PostMapping
public ResponseEntity<CadAmf> criar(@RequestBody CadAmf cadAmf, HttpServletResponse response){
	CadAmf CadAmfSalvar = mftcadAmfRepository.save(cadAmf);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{d20_cdarea}")
	.buildAndExpand(CadAmfSalvar.getCdarea()).toUri();
	response.setHeader("Location", uri.toASCIIString());
	return ResponseEntity.created(uri).body(CadAmfSalvar);
}

@GetMapping("/{d20_cdarea}")
public CadAmf CadAmf_Buscar_Pelo_Id(@PathVariable Long d20_cdarea) {
	return mftcadAmfRepository.findOne(d20_cdarea);
}

@DeleteMapping("/{codigo}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void Remover(@PathVariable Long codigo) {
	mftcadAmfRepository.delete(codigo);
	
       }

  @PutMapping("/{codigo}")
  public ResponseEntity<CadAmf> atualizar(@PathVariable Long codigo, @Valid @RequestBody CadAmf cadAmf){
	  CadAmf cadAmfSalva = mftcadAmfRepository.findOne(codigo);
	   BeanUtils.copyProperties(cadAmf, cadAmfSalva, "codigo");
	    mftcadAmfRepository.save(cadAmfSalva);
	     return ResponseEntity.ok(cadAmfSalva);
  }
 

}
