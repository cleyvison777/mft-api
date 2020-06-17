package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadClassTamanhoIndividuo;
import com.embrapa.mft.repository.CadClassTamanhoIndividuoRepository;

@Service
public class CadClassTamanhoIndividuoService {
	
	@Autowired
	private CadClassTamanhoIndividuoRepository cadClassTamanhoIndividuoRepository;
	
	public CadClassTamanhoIndividuo atualizar(Long codigo, CadClassTamanhoIndividuo cadClassTamanhoIndividuo) {
		CadClassTamanhoIndividuo cadClassTamanhoIndividuoSalva = buscarPeloCodigo(codigo);
		 BeanUtils.copyProperties(cadClassTamanhoIndividuo, cadClassTamanhoIndividuoSalva, "codigo");
		  return cadClassTamanhoIndividuoRepository.save(cadClassTamanhoIndividuoSalva);
	}

	private CadClassTamanhoIndividuo buscarPeloCodigo(Long codigo) {
		CadClassTamanhoIndividuo cadClassTamanhoIndividuoSalva = cadClassTamanhoIndividuoRepository.findOne(codigo);
		 if(cadClassTamanhoIndividuoSalva == null) {
			 throw new EmptyResultDataAccessException(1);
		 }
		return cadClassTamanhoIndividuoSalva;
	}

}
