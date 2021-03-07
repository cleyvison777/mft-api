package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadUsoEspecie;
import com.embrapa.mft.repository.CadUsoEspecieRepository;

@Service
public class CadUsoEspecieService {
	
	@Autowired 
	private CadUsoEspecieRepository cadUsoEspecieRepository;

	public CadUsoEspecie atualizar(Long cduso, CadUsoEspecie usoEspecie)  {
		  CadUsoEspecie usoEspecieSalva = buscarGeneroPeloCodigo(cduso);
		    BeanUtils.copyProperties(usoEspecie, usoEspecieSalva, "codigo");
		      return cadUsoEspecieRepository.save(usoEspecieSalva);
	}

    private CadUsoEspecie  buscarGeneroPeloCodigo(Long cdUso) {
	      CadUsoEspecie usoEspecieSalva = cadUsoEspecieRepository.findOne(cdUso);
		     if(usoEspecieSalva == null) {
		    	 throw new EmptyResultDataAccessException(1);
		     }
		     
		     return usoEspecieSalva;
	}
}
