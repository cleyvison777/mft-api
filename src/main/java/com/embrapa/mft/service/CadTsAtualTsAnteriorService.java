package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadTsAtualTsAnterior;
import com.embrapa.mft.repository.CadTsAtualTsAnteriorRepository;

@Service
public class CadTsAtualTsAnteriorService {

	@Autowired
	private CadTsAtualTsAnteriorRepository cadTsAtualTsAnteriorRepository;
	
	public CadTsAtualTsAnterior atualizar(Long codigo, CadTsAtualTsAnterior cadTsAtualTsAnterior) {
		CadTsAtualTsAnterior cadTsAtualTsAnteriorSalva = buscarCadTsAtualTsAnteriorPeloCodigo(codigo);
		BeanUtils.copyProperties(cadTsAtualTsAnterior, cadTsAtualTsAnteriorSalva, "codigo");
		
		 return cadTsAtualTsAnteriorRepository.save(cadTsAtualTsAnteriorSalva);
		
	}
	
	public CadTsAtualTsAnterior buscarCadTsAtualTsAnteriorPeloCodigo(Long codigo) {
		CadTsAtualTsAnterior cadTsAtualTsAnteriorSalva = cadTsAtualTsAnteriorRepository.findOne(codigo);
		if(cadTsAtualTsAnteriorSalva == null) {
			
		   throw new EmptyResultDataAccessException(1);
		}
		return cadTsAtualTsAnteriorSalva;
	}
}
