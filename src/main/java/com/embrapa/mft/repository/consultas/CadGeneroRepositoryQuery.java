package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadGenero;
import com.embrapa.mft.repository.filter.CadGeneroFilter;

public interface CadGeneroRepositoryQuery {
	
  public Page<CadGenero> filtrar(CadGeneroFilter cadGeneroFilter, Pageable pageable);
  
}
