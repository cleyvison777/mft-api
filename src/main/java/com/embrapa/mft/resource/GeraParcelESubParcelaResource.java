package com.embrapa.mft.resource;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.embrapa.mft.event.RecursoCriadoEvent;
import com.embrapa.mft.model.CadAmf;
import com.embrapa.mft.model.MenuEmpresa;
import com.embrapa.mft.model.fnc.GeraParcelESubParcela;
import com.embrapa.mft.repository.procedimentos.GeraParcelESubParcelaRepository;

@RestController
@RequestMapping("/geraparcelaesubparcelas")
public class GeraParcelESubParcelaResource {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private GeraParcelESubParcelaRepository geraParcelESubParcelaRepository;
	
		
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMPRESA') and #oauth2.hasScope('write')")
	public ResponseEntity<GeraParcelESubParcela> criar(@RequestBody GeraParcelESubParcela geraParcelESubParcela, HttpServletResponse response) {
		
		GeraParcelESubParcela geraParcelESubParcelaSalva = geraParcelESubParcelaRepository.save(geraParcelESubParcela); 
		publisher.publishEvent(new RecursoCriadoEvent(this, response, geraParcelESubParcelaSalva.getId()));
		
		int contapar;
		int contasubpar;
		int qtdexiste;
		int qtdexisteSub;
		
		contapar = geraParcelESubParcelaSalva.getCdParcelaInicio();
		
				
		while(contapar < geraParcelESubParcelaSalva.getCdParcelaInicio() + geraParcelESubParcelaSalva.getNrParcelas()) {
			
			qtdexiste = geraParcelESubParcelaRepository.qtdexiste(geraParcelESubParcelaSalva.getCdEmpresa(), 
					geraParcelESubParcelaSalva.getCdArea(), contapar);	
			
			
			if(qtdexiste == 0) {
				System.out.println("Empresa: " + geraParcelESubParcelaSalva.getCdEmpresa());
				System.out.println("Area: " + geraParcelESubParcelaSalva.getCdArea());
				System.out.println("contapar: " + contapar);
				System.out.println("Tipo Parcela: " + geraParcelESubParcelaSalva.getCdTipoParcela());
				
				geraParcelESubParcelaRepository.inserirParcela(geraParcelESubParcelaSalva.getCdEmpresa(), 
						geraParcelESubParcelaSalva.getCdArea(), contapar ,geraParcelESubParcelaSalva.getCdTipoParcela());
			}
			
			contasubpar = 1;
			while(contasubpar <= geraParcelESubParcelaSalva.getNrSubParcelasPorParcelas()) {
				
				qtdexisteSub = geraParcelESubParcelaRepository.qtdexisteSub(geraParcelESubParcelaSalva.getCdEmpresa(),geraParcelESubParcela.getCdArea(), contapar,contasubpar);
				
				if(qtdexisteSub == 0) {
					geraParcelESubParcelaRepository.inserirSubParcela(geraParcelESubParcelaSalva.getCdEmpresa(),
					geraParcelESubParcelaSalva.getCdArea(),contapar , contasubpar);					
					
				}
				
				contasubpar++;
			}
			contapar++;
		}
		
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(geraParcelESubParcelaSalva);
	}
	
	

}
