package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.Genero;
import com.embrapa.mft.repository.CadGeneroRepository;

@Service
public class GeneroService {
	
	@Autowired
	private CadGeneroRepository cadGeneroRepository;
	
	public Genero atualizar(Long cdGenero, Genero genero) {
		Genero generoSalva = buscarGeneroPeloCodigo(cdGenero);
		 BeanUtils.copyProperties(genero, generoSalva, "codigo");
		   return cadGeneroRepository.save(generoSalva);
	}

	private Genero buscarGeneroPeloCodigo(Long cdGenero) {
		Genero generoSalva = cadGeneroRepository.findOne(cdGenero);
		 if(generoSalva == null) {
			  throw new EmptyResultDataAccessException(1);

		 }
		return generoSalva;
	}

}
