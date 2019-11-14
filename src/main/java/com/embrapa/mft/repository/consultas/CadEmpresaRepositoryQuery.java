package com.embrapa.mft.repository.consultas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.embrapa.mft.model.CadEmpresa;
import com.embrapa.mft.repository.filter.CadEmpresaFilter;


public interface CadEmpresaRepositoryQuery {

	public Page<CadEmpresa> filtrar(CadEmpresaFilter cadEmpresaFilter, Pageable pageable);
	
	
}
