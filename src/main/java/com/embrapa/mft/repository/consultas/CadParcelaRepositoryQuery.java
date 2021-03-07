package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadParcela;
import com.embrapa.mft.repository.filter.CadParcelaFilter;


public interface CadParcelaRepositoryQuery {

	public Page<CadParcela> filtrar(CadParcelaFilter cadParcelaaFilter, Pageable pageable);
}
