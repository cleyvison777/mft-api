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
 
 
 public CadFamilia atualizar(Long codigo, CadFamilia cadFamilia) {
	 CadFamilia cadFamiliaSalva = buscarFamiliaPeloCodigo(codigo);
	  BeanUtils.copyProperties(cadFamilia, cadFamiliaSalva, "codigo");
	   return cadFamiliaRepository.save(cadFamiliaSalva);
 }
 
 public CadFamilia buscarFamiliaPeloCodigo(Long codigo) {
	 CadFamilia cadFamiliaSalva = cadFamiliaRepository.findOne(codigo);
	  if(cadFamiliaSalva == null) {
		  throw new EmptyResultDataAccessException(1);
	  }
	  
	  return cadFamiliaSalva;
 }
}
