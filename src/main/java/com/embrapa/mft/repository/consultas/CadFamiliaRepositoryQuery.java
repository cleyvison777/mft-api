package com.embrapa.mft.repository.consultas;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadFamilia;
import com.embrapa.mft.repository.filter.CadFamiliaFilter;

public interface CadFamiliaRepositoryQuery {

	public Page<CadFamilia> filtrar(CadFamiliaFilter cadFamiliaFilter,Pageable pageable);
		
}
