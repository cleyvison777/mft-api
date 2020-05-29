package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadTipoParcela;
import com.embrapa.mft.repository.filter.CadTipoParcelaFilter;

public interface CadTipoParcelaRepositoryQuery {

	
	public Page<CadTipoParcela> filtrar(CadTipoParcelaFilter cadTipoParcelaFilter, Pageable pageable);
}
