package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadEmpresa;
import com.embrapa.mft.repository.CadEmpresaRepository;

@Service
public class CadEmpresaService {

	@Autowired
	private CadEmpresaRepository cadEmpresaRepository;
	
	
	public CadEmpresa atualizar(Long codigo, CadEmpresa cadEmpresa) {
		
		CadEmpresa cadEmpresaSalva = buscarEmpresaPeloCodigo(codigo);
		BeanUtils.copyProperties(cadEmpresa, cadEmpresaSalva, "codigo");
		return cadEmpresaRepository.save(cadEmpresaSalva);
	}
	
	

	public CadEmpresa buscarEmpresaPeloCodigo(Long codigo) {
		CadEmpresa cadEmpresaSalva = cadEmpresaRepository.findOne(codigo);
		if (cadEmpresaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return cadEmpresaSalva;
	}
	
}
