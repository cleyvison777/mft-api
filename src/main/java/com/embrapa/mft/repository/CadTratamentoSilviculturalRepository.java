package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadTratamentoSilvicultural;
import com.embrapa.mft.repository.consultas.CadTratamentoSilviculturalRepositoryQuery;

public interface CadTratamentoSilviculturalRepository extends JpaRepository<CadTratamentoSilvicultural, Long>, CadTratamentoSilviculturalRepositoryQuery {

}
