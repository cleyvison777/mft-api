package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadListaEspecie;
import com.embrapa.mft.repository.consultas.CadListaEspecieRepositoryQuery;

public interface CadListaEspecieRepository extends JpaRepository<CadListaEspecie, Long>, CadListaEspecieRepositoryQuery {

}
 