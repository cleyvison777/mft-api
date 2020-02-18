package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadAmf;
import com.embrapa.mft.repository.filter.CadAmfFilter;


public interface CadAmfRepositoryQuery {
	
	public Page<CadAmf> filtrar(CadAmfFilter cadAmfFilter, Pageable pageable);

}
