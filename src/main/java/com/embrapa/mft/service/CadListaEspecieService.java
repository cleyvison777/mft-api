package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadListaEspecie;
import com.embrapa.mft.repository.CadListaEspecieRepository;

@Service
public class CadListaEspecieService{
 
	 @Autowired
	  private CadListaEspecieRepository cadListaEspecieRepository;
	   
	   public CadListaEspecie atualizar(Long codigo, CadListaEspecie listaEspecie) {
		   CadListaEspecie listaEspecieSalva = buscarListaEspeciePeloCodigo(codigo);
		   BeanUtils.copyProperties(listaEspecie, listaEspecieSalva, "codigo");
		     return cadListaEspecieRepository.save(listaEspecieSalva);
		    
		   
	   }
	    
	   public CadListaEspecie buscarListaEspeciePeloCodigo(Long codigo) {
		   CadListaEspecie listaEspecieSalva = cadListaEspecieRepository.findOne(codigo);
		     if(listaEspecieSalva == null) {
		    	 throw new EmptyResultDataAccessException(1);
		     }
		     return listaEspecieSalva;
	   }
	
	
}
