package com.embrapa.mft.resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.embrapa.mft.event.RecursoCriadoEvent;
import com.embrapa.mft.model.ICClasseDeFloresta;
import com.embrapa.mft.repository.ICClasseDeFlorestaRepository;
import com.embrapa.mft.repository.filter.ICClasseDeFlorestaFilter;
import com.embrapa.mft.service.ICClasseDeFlorestaService;

@RestController
@RequestMapping("/icclasefloresta") 
public class ICClasseDeFlorestaResouce {
	
	@Autowired
	private ICClasseDeFlorestaRepository iCClasseDeFlorestaRepository;
	
	@Autowired
	private ICClasseDeFlorestaService iCClasseDeFlorestaService;
	
	
	@Autowired
	 private ApplicationEventPublisher publisher;
	
    @GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ESPECIE') and #oauth2.hasScope('read')")
	public Page<ICClasseDeFloresta> pesquisar(ICClasseDeFlorestaFilter iCClasseDeFlorestaFilter, Pageable pageable){ 
    	return iCClasseDeFlorestaRepository.filtrar(iCClasseDeFlorestaFilter, pageable); 
    }
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ESPECIE') and #oauth2.hasScope('write')")
	 public ResponseEntity<ICClasseDeFloresta> criar(@RequestBody ICClasseDeFloresta iCClasseDeFloresta, HttpServletResponse response){
		ICClasseDeFloresta iCClasseDeFlorestaSalva = iCClasseDeFlorestaRepository.save(iCClasseDeFloresta);
		   publisher.publishEvent(new RecursoCriadoEvent(this, response, iCClasseDeFlorestaSalva.getCdClassefloresta()));
		            return ResponseEntity.status(HttpStatus.CREATED).body(iCClasseDeFlorestaSalva);
	}
	
	@PostMapping("anexarimagem")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ESPECIE') and #oauth2.hasScope('write')")
	public String upLoadImagem(@RequestParam MultipartFile anexo, ICClasseDeFloresta cdClassefloresta) throws IOException {
		String id = Long.toString(cdClassefloresta.getCdClassefloresta());
		OutputStream out = new FileOutputStream("G://Documentos/Projetos/Embrapa/mft-ui-1.2/src/assets/imgclaflo/" + "img"+"cdClassefloresta"+id+".jpg"); // AJUSTAR AQUI		
		String url = "../assets/imgclaflo/" + "img"+"cdClassefloresta"+id+".jpg"; // AJUSTAR AQUI 
     	iCClasseDeFlorestaRepository.atualizarUrlImagem(cdClassefloresta, url);
		out.write(anexo.getBytes());
		out.close();
		return "OK";
	}

	@GetMapping("/{d05_lista_especie}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ESPECIE') and #oauth2.hasScope('read')")
	public ResponseEntity<ICClasseDeFloresta> ListaEspecie_Buscar_Pelo_Id(@PathVariable Long d05_lista_especie) {
		ICClasseDeFloresta iCClasseDeFloresta = iCClasseDeFlorestaRepository.findOne(d05_lista_especie);
		 return iCClasseDeFloresta != null ? ResponseEntity.ok(iCClasseDeFloresta) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cdClassefloresta}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_ESPECIE') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	 public void Remover(@PathVariable Long cdClassefloresta) {
		iCClasseDeFlorestaRepository.delete(cdClassefloresta);
	}
	
	
	@PutMapping("/{cdClassefloresta}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_ESPECIE') and #oauth2.hasScope('write')")
	public ResponseEntity<ICClasseDeFloresta> atualizar(@PathVariable Long cdClassefloresta, @Valid @RequestBody ICClasseDeFloresta iCClasseDeFloresta){
		 
		ICClasseDeFloresta iCClasseDeFlorestaSalva = iCClasseDeFlorestaService.atualizar(cdClassefloresta, iCClasseDeFloresta);
		   return ResponseEntity.ok(iCClasseDeFlorestaSalva);
		   
	}
	
	
	
}
