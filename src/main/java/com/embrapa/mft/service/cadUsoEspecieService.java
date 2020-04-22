package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.UsoEspecie;
import com.embrapa.mft.repository.CadUsoEspecieRepository;

@Service
public class cadUsoEspecieService {
	
@Autowired 
private CadUsoEspecieRepository cadUsoEspecieRepository;

  public UsoEspecie atualizar(Long cduso, UsoEspecie usoEspecie)  {
	  UsoEspecie usoEspecieSalva = buscarGeneroPeloCodigo(cduso);
	    BeanUtils.copyProperties(usoEspecie, usoEspecieSalva, "codigo");
	      return cadUsoEspecieRepository.save(usoEspecieSalva);
  }

  
  private UsoEspecie  buscarGeneroPeloCodigo(Long cdUso) {
	  UsoEspecie usoEspecieSalva = cadUsoEspecieRepository.findOne(cdUso);
	     if(usoEspecieSalva == null) {
	    	 throw new EmptyResultDataAccessException(1);
	     }
	     
	     return usoEspecieSalva;
  }
}
