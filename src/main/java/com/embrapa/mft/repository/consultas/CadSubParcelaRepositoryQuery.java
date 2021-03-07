package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadSubParcela;
import com.embrapa.mft.repository.filter.CadSubParcelaFilter;


public interface CadSubParcelaRepositoryQuery {

	public Page<CadSubParcela> filtrar(CadSubParcelaFilter cadSubParcelaaFilter, Pageable pageable);
	
}
