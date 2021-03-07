package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadGenero;
import com.embrapa.mft.repository.consultas.CadGeneroRepositoryQuery;

public interface CadGeneroRepository  extends JpaRepository<CadGenero, Long>, CadGeneroRepositoryQuery{
	
	

}
