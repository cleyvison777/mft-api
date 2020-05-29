package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadTipoParcela;
import com.embrapa.mft.repository.CadTipoParcelaRepository;

@Service
public class CadTipoParcelaService {
	
	@Autowired
	private CadTipoParcelaRepository cadTipoParcelaRepository;
	
	public CadTipoParcela atualizar(Long cdTipoParcela, CadTipoParcela cadTipoParcela) {
		CadTipoParcela cadTipoParcelaSalva = buscarCadTipoParcelaPeloCodigo(cdTipoParcela);
		  BeanUtils.copyProperties(cadTipoParcela, cadTipoParcelaSalva, "codigo");
		   return cadTipoParcelaRepository.save(cadTipoParcelaSalva);
	}
	
	 public CadTipoParcela buscarCadTipoParcelaPeloCodigo(Long cdTipoParcela) {
		 CadTipoParcela cadTipoParcelaSalva = cadTipoParcelaRepository.findOne(cdTipoParcela);
		  if(cadTipoParcelaSalva == null) {
			  throw new EmptyResultDataAccessException(1);
		  }
		  
		  return cadTipoParcelaSalva;
	 }

}
