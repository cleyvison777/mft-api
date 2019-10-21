package com.embrapa.mft.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.embrapa.mft.model.CadClasseTamanhoIndividuo;
import com.embrapa.mft.repository.CadClasseTamanhoIndividuoRepository;

@RestController
@RequestMapping("/d10_classe_tamanho_individuo")
public class CadClasseTamanhoIndividuoResouce {
@Autowired
private CadClasseTamanhoIndividuoRepository mftCadClasseTamanhoIndividuoRepository;
	
@GetMapping
public List<CadClasseTamanhoIndividuo> ListarClasseTamanhoIndividuo(){
	return mftCadClasseTamanhoIndividuoRepository.findAll();
    }


@PostMapping
public ResponseEntity<CadClasseTamanhoIndividuo> criar (@RequestBody CadClasseTamanhoIndividuo cadClasseTamanhoIndividuo, HttpServletResponse response){
	CadClasseTamanhoIndividuo ClasseTamanhoIndividuoSalvar = mftCadClasseTamanhoIndividuoRepository.save(cadClasseTamanhoIndividuo);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{d10_cdclassetamanho}")
			.buildAndExpand(ClasseTamanhoIndividuoSalvar.getCdcClasseTamanho()).toUri();
	         response.setHeader("Location", uri.toASCIIString());
	          return ResponseEntity.created(uri).body(ClasseTamanhoIndividuoSalvar);
      }   

   @PutMapping("/{codigo}")
   public ResponseEntity<CadClasseTamanhoIndividuo> atualizar(@PathVariable Long codigo, @Valid @RequestBody CadClasseTamanhoIndividuo cadClasseTamanhoIndividuo){
	   CadClasseTamanhoIndividuo cadClasseTamanhoIndividuoSalva = mftCadClasseTamanhoIndividuoRepository.findOne(codigo);
	    BeanUtils.copyProperties(cadClasseTamanhoIndividuo, cadClasseTamanhoIndividuoSalva, "codigo");
	     mftCadClasseTamanhoIndividuoRepository.save(cadClasseTamanhoIndividuoSalva);
	      return ResponseEntity.ok(cadClasseTamanhoIndividuoSalva);
   }
    

}
