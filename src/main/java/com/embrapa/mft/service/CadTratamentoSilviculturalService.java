package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadTratamentoSilvicultural;
import com.embrapa.mft.repository.CadTratamentoSilviculturalRepository;

@Service
public class CadTratamentoSilviculturalService {
	@Autowired
	private CadTratamentoSilviculturalRepository cadTratamentoSilviculturalRepository;
	
	
	public CadTratamentoSilvicultural atualizar(Long codigo, CadTratamentoSilvicultural cadTratamentoSilvicultural) {
		CadTratamentoSilvicultural cadTratamentoSilviculturalSalva = buscarTratamentoSilviculturalPeloCodigo(codigo);
		  BeanUtils.copyProperties(cadTratamentoSilvicultural, cadTratamentoSilviculturalSalva, "codigo");
		   return cadTratamentoSilviculturalRepository.save(cadTratamentoSilviculturalSalva);
		
	}
	
	
	public CadTratamentoSilvicultural buscarTratamentoSilviculturalPeloCodigo(Long codigo) {
		CadTratamentoSilvicultural cadTratamentoSilviculturalSalva = cadTratamentoSilviculturalRepository.findOne(codigo);
		 if(cadTratamentoSilviculturalSalva == null) {
			 throw new EmptyResultDataAccessException(1);
		 }
		 return cadTratamentoSilviculturalSalva;
	}

}
