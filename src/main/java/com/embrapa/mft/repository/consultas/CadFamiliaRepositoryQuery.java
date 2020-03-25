package com.embrapa.mft.repository.consultas;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadFamilia;
import com.embrapa.mft.repository.filter.CadFamiliaFilter;

public interface CadFamiliaRepositoryQuery {

	public List<CadFamilia> filtrar(CadFamiliaFilter cadFamiliaFilter);
		
}
