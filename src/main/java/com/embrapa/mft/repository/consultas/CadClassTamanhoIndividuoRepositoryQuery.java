package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadClassTamanhoIndividuo;
import com.embrapa.mft.repository.filter.CadClassTamanhoIndividuoFilter;

public interface CadClassTamanhoIndividuoRepositoryQuery {
	
	public Page<CadClassTamanhoIndividuo> filtrar(CadClassTamanhoIndividuoFilter cadClassTamanhoIndividuoFilter, Pageable pageable);
}
