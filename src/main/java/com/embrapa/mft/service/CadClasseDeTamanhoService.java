package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadClasseDeTamanho;
import com.embrapa.mft.repository.CadClasseDeTamanhoRepository;


@Service
public class CadClasseDeTamanhoService {
	
	@Autowired
	private CadClasseDeTamanhoRepository cadClasseDeTamanhoRepository;
	
	public CadClasseDeTamanho atualizar(Long codigo, CadClasseDeTamanho cadClasseDeTamanho) {
		CadClasseDeTamanho cadClasseDeTamanhoSalva = buscarPeloCodigo(codigo);
		 BeanUtils.copyProperties(cadClasseDeTamanho, cadClasseDeTamanhoSalva, "codigo");
		  return cadClasseDeTamanhoRepository.save(cadClasseDeTamanhoSalva);
	}

	private CadClasseDeTamanho buscarPeloCodigo(Long codigo) {
		CadClasseDeTamanho cadClasseDeTamanhoSalva = cadClasseDeTamanhoRepository.findOne(codigo);
		 if(cadClasseDeTamanhoSalva == null) {
			 throw new EmptyResultDataAccessException(1);
		 }
		return cadClasseDeTamanhoSalva;
	}

}
