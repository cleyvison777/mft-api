package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.ICClasseDeFloresta;
import com.embrapa.mft.repository.ICClasseDeFlorestaRepository;

@Service
public class ICClasseDeFlorestaService {

	@Autowired
	private ICClasseDeFlorestaRepository iCClasseDeFlorestaRepository;
	
	
	public ICClasseDeFloresta atualizar(Long codigo, ICClasseDeFloresta iCClasseDeFloresta) {
		
		 ICClasseDeFloresta iCClasseDeFlorestaSalva = buscar_arvore_peloID(codigo);
		 BeanUtils.copyProperties(iCClasseDeFloresta, iCClasseDeFlorestaSalva, "codigo");
		  return iCClasseDeFlorestaRepository.save(iCClasseDeFlorestaSalva);
	}


	private ICClasseDeFloresta buscar_arvore_peloID(Long condigo) {
		ICClasseDeFloresta iCClasseDeFlorestaSalva =  iCClasseDeFlorestaRepository.findOne(condigo);
		if(iCClasseDeFlorestaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return iCClasseDeFlorestaSalva;
	}
	
}
