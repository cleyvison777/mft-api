package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadClasseDeTamanho;
import com.embrapa.mft.repository.filter.CadClasseDeTamanhoFilter;

public interface CadClasseDeTamanhoRepositoryQuery {

	public Page<CadClasseDeTamanho> filtrar(CadClasseDeTamanhoFilter cadClassTamanhoFilter, Pageable pageable);
	
}
