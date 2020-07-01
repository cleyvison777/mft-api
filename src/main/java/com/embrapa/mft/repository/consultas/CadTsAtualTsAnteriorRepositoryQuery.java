package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadTsAtualTsAnterior;
import com.embrapa.mft.repository.filter.CadTsAtualTsAnteriorFilter;

public interface CadTsAtualTsAnteriorRepositoryQuery {

	public Page<CadTsAtualTsAnterior> filtrar(CadTsAtualTsAnteriorFilter cadTsAtualTsAnteriorFilter, Pageable pageable);
}
