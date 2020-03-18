package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadCategoriaProtecao;
import com.embrapa.mft.repository.filter.CadCategoriaProtecaoFilter;

public interface CadCategoriaProtecaoRepositoryQuery {
	Page<CadCategoriaProtecao> filtrar(CadCategoriaProtecaoFilter cadCategoriaProtecaoFilter, Pageable pageable);
}
