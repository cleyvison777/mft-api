package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadListaEspecie;
import com.embrapa.mft.repository.filter.CadListaEspecieFilter;

public interface CadListaEspecieRepositoryQuery {

	public Page<CadListaEspecie> filtrar(CadListaEspecieFilter cadListaEspecieFilter, Pageable pageable);
}
