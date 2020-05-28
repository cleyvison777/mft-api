package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadTipoParcela;
import com.embrapa.mft.repository.CadTipoParcelaRepository;

@Service
public class CadTipoParcelaService {
   @Autowired
     private CadTipoParcelaRepository cadTipoParcelaRepository;
   
   
   public CadTipoParcela atualiza(Long cdTipoparcela, CadTipoParcela cadTipoParcela) {
	   CadTipoParcela cadTipoParcelaSalva = buscarTipoParcelaPeloCodigo(cdTipoparcela);
	   BeanUtils.copyProperties(cadTipoParcela, cadTipoParcelaSalva, "codigo");
	    return cadTipoParcelaRepository.save(cadTipoParcelaSalva);
   }


private CadTipoParcela buscarTipoParcelaPeloCodigo(Long cdTipoparcela) {
	CadTipoParcela cadTipoParcelaSalva = cadTipoParcelaRepository.findOne(cdTipoparcela);
	   if(cadTipoParcelaSalva == null) {
		   throw new EmptyResultDataAccessException(1);
	   }
	return cadTipoParcelaSalva;
  }
   
   
}
