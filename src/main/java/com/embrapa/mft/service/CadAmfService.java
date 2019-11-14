package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.embrapa.mft.model.CadAmf;
import com.embrapa.mft.repository.CadAmfRepository;

@Service
public class CadAmfService {

	@Autowired
	private CadAmfRepository cadAmfRepository;
	
	public CadAmf atualizar(Long codigo, CadAmf cadAmf) {
		CadAmf cadAmfSalva = buscarAmfPeloCodigo(codigo);
		BeanUtils.copyProperties(cadAmf, cadAmfSalva, "codigo");
		return cadAmfRepository.save(cadAmfSalva);
		
	}

	public CadAmf buscarAmfPeloCodigo(Long codigo) {
		CadAmf cadAmfSalva = cadAmfRepository.findOne(codigo);
		if(cadAmfSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return cadAmfSalva;
	}
}
