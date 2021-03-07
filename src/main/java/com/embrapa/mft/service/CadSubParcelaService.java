package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadSubParcela;
import com.embrapa.mft.repository.CadSubParcelaRepository;


@Service
public class CadSubParcelaService {

	@Autowired
	private CadSubParcelaRepository cadSubParcelaRepository;
	
	
	public CadSubParcela atualizar(Long codigo, CadSubParcela cadSubParcela) {
		
		CadSubParcela cadSubParcelaSalva = buscarEmpresaPeloCodigo(codigo);
		BeanUtils.copyProperties(cadSubParcela, cadSubParcelaSalva, "codigo");
		return cadSubParcelaRepository.save(cadSubParcelaSalva);
	}
	
	

	public CadSubParcela buscarEmpresaPeloCodigo(Long codigo) {
		CadSubParcela cadSubParcelaSalva = cadSubParcelaRepository.findOne(codigo);
		if (cadSubParcelaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return cadSubParcelaSalva;
	}
	
}
