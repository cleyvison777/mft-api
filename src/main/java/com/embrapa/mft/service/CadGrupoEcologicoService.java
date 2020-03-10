package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadGrupoEcologico;
import com.embrapa.mft.repository.CadGrupoEcologicoRepository;

@Service
public class CadGrupoEcologicoService {

	
	@Autowired
	private CadGrupoEcologicoRepository  cadGrupoEcologicoRepository;
	
	public CadGrupoEcologico atualiza(Long cdGrupoEcologico, CadGrupoEcologico cadGrupoEcologico) {
		CadGrupoEcologico cadGrupoEcologicoSalva = buscarGrupoPeloCodigo(cdGrupoEcologico);
		 BeanUtils.copyProperties(cadGrupoEcologico, cadGrupoEcologicoSalva, "codigo");
		   return cadGrupoEcologicoRepository.save(cadGrupoEcologicoSalva);
	}


	private CadGrupoEcologico buscarGrupoPeloCodigo(Long cdGrupoEcologico) {

       CadGrupoEcologico cadGrupoEcologicoSalva = cadGrupoEcologicoRepository.findOne(cdGrupoEcologico);
       if(cadGrupoEcologicoSalva == null) {
    	   throw new EmptyResultDataAccessException(1);
       }
		return cadGrupoEcologicoSalva;
	}
}
