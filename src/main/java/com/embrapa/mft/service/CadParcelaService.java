package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadParcela;
import com.embrapa.mft.repository.CadParcelaRepository;


@Service
public class CadParcelaService {

	@Autowired
	private CadParcelaRepository cadParcelaRepository;
	
	
	public CadParcela atualizar(Long codigo, CadParcela cadParcela) {
		
		CadParcela cadParcelaSalva = buscarEmpresaPeloCodigo(codigo);
		BeanUtils.copyProperties(cadParcela, cadParcelaSalva, "codigo");
		return cadParcelaRepository.save(cadParcelaSalva);
	}
	
	

	public CadParcela buscarEmpresaPeloCodigo(Long codigo) {
		CadParcela cadParcelaSalva = cadParcelaRepository.findOne(codigo);
		if (cadParcelaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return cadParcelaSalva;
	}
	
}
