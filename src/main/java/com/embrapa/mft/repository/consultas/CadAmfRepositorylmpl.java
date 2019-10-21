package com.embrapa.mft.repository.consultas;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadAmf;
import com.embrapa.mft.repository.filter.CadAmfFilter;

public class CadAmfRepositorylmpl  implements CadAmfRepositoryQuery{

	@PersistenceContext
	 private EntityManager manager;
	
	@Override
	public Page<CadAmf> filtrar(CadAmfFilter cadAmfFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
