package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadTratamentoSilvicultural;
import com.embrapa.mft.repository.filter.CadTratamentoSilviculturalFilter;

public interface CadTratamentoSilviculturalRepositoryQuery {

	public Page<CadTratamentoSilvicultural> filtrar(CadTratamentoSilviculturalFilter cadTratamentoSilviculturalFilter, Pageable pageable);
}
