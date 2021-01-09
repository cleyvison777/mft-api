package com.embrapa.mft.repository.consultas;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.ICClasseDeFloresta;
import com.embrapa.mft.repository.filter.ICClasseDeFlorestaFilter;

public interface ICClasseDeFlorestaRepositoryQuery {

	public Page<ICClasseDeFloresta> filtrar(ICClasseDeFlorestaFilter iCClasseDeFlorestaFilter,Pageable pageable);
		
}
