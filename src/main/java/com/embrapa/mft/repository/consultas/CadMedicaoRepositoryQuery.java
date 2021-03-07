package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadMedicao;
import com.embrapa.mft.repository.filter.CadMedicaoFilter;

public interface CadMedicaoRepositoryQuery {
	
	public Page<CadMedicao> filtrar(CadMedicaoFilter cadMedicaoFilter, Pageable pageable); 

}
