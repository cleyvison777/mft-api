package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadFamilia;
import com.embrapa.mft.repository.CadFamiliaRepository;

@Service
public class CadFamiliaService {
 @Autowired
  private CadFamiliaRepository cadFamiliaRepository;
 
 
 public CadFamilia atualizar(Long cdFamilia, CadFamilia cadFamilia) {
	 CadFamilia cadFamiliaSalva = buscarFamiliaPeloCodigo(cdFamilia);
	  BeanUtils.copyProperties(cadFamilia, cadFamiliaSalva, "codigo");
	   return cadFamiliaRepository.save(cadFamiliaSalva);
 }
 
 public CadFamilia buscarFamiliaPeloCodigo(Long cdFamilia) {
	 CadFamilia cadFamiliaSalva = cadFamiliaRepository.findOne(cdFamilia);
	  if(cadFamiliaSalva == null) {
		  throw new EmptyResultDataAccessException(1);
	  }
	  
	  return cadFamiliaSalva;
 }
}
