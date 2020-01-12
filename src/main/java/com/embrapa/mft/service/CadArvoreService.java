package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.embrapa.mft.model.CadArvore;
import com.embrapa.mft.repository.CadArvoreRepository;

public class CadArvoreService {

	@Autowired
	private CadArvoreRepository cadArvoreRepository;
	
	
	public CadArvore atualizar(Long condigo, CadArvore cadArvore) {
		
		 CadArvore cadArvoreSalva = buscar_arvore_peloID(condigo);
		 BeanUtils.copyProperties(cadArvore, cadArvoreSalva, "codigo");
		  return cadArvoreRepository.save(cadArvoreSalva);
	}


	private CadArvore buscar_arvore_peloID(Long condigo) {
		CadArvore cadArvoreSalva =  cadArvoreRepository.findOne(condigo);
		if(cadArvoreSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return cadArvoreSalva;
	}
	
}
