package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.MenuEmpresa;
import com.embrapa.mft.repository.filter.MenuEmpresaFilter;



public interface MenuEmpresaRepositoryQuery {
	
	public Page<MenuEmpresa> filtrar(MenuEmpresaFilter menuEmpresaFilter, Pageable pageable);

}
