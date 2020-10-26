package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadTsAtualTsAnterior;
import com.embrapa.mft.repository.consultas.CadTsAtualTsAnteriorRepositoryQuery;

public interface CadTsAtualTsAnteriorRepository extends JpaRepository<CadTsAtualTsAnterior, Long>, CadTsAtualTsAnteriorRepositoryQuery {

	
}
