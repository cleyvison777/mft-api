package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadCategoriaProtecao;
import com.embrapa.mft.repository.CadCategoriaProtecaoRepository;

@Service
public class CadCategoriaProtecaoService {

	  @Autowired
	  private CadCategoriaProtecaoRepository cadCategoriaProtecaoRepository;
	    
	   public CadCategoriaProtecao atualizar(Long cdCategoriaProtecao, CadCategoriaProtecao cadCategoriaProtecao) {
		    CadCategoriaProtecao cadCategoriaProtecaoSalva = buscarProtecaoPeloCodigo(cdCategoriaProtecao);
		      BeanUtils.copyProperties(cadCategoriaProtecao, cadCategoriaProtecaoSalva, "codigo");
		       return cadCategoriaProtecaoRepository.save(cadCategoriaProtecaoSalva);
	   }

	private CadCategoriaProtecao buscarProtecaoPeloCodigo(Long cdCategoriaProtecao) {
		CadCategoriaProtecao cadCategoriaProtecaoSalva = cadCategoriaProtecaoRepository.findOne(cdCategoriaProtecao);
		     if(cadCategoriaProtecaoSalva == null) {
				  throw new EmptyResultDataAccessException(1);

		     }
		return cadCategoriaProtecaoSalva;
	}
}
