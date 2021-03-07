package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadMedicao;
import com.embrapa.mft.repository.CadMedicaoRepository;


@Service
public class CadMedicaoService {
	
	@Autowired
	private CadMedicaoRepository cadMedicaoRepository;
	
	public CadMedicao atualizar(Long cdMedicao, CadMedicao medicao) {
		CadMedicao medicaoSalva = buscarMedicaoPeloCodigo(cdMedicao);
		 BeanUtils.copyProperties(medicao, medicaoSalva, "codigo");
		   return cadMedicaoRepository.save(medicaoSalva);
	}

	private CadMedicao buscarMedicaoPeloCodigo(Long cdMedicao) {
		CadMedicao medicaoSalva = cadMedicaoRepository.findOne(cdMedicao);
		 if(medicaoSalva == null) {
			  throw new EmptyResultDataAccessException(1);

		 }
		return medicaoSalva;
	}

}
