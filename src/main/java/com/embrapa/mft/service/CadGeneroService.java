package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadGenero;
import com.embrapa.mft.repository.CadGeneroRepository;

@Service
public class CadGeneroService {
	
	@Autowired
	private CadGeneroRepository cadGeneroRepository;
	
	public CadGenero atualizar(Long cdGenero, CadGenero genero) {
		CadGenero generoSalva = buscarGeneroPeloCodigo(cdGenero);
		 BeanUtils.copyProperties(genero, generoSalva, "codigo");
		   return cadGeneroRepository.save(generoSalva);
	}

	private CadGenero buscarGeneroPeloCodigo(Long cdGenero) {
		CadGenero generoSalva = cadGeneroRepository.findOne(cdGenero);
		 if(generoSalva == null) {
			  throw new EmptyResultDataAccessException(1);

		 }
		return generoSalva;
	}

}
