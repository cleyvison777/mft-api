package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadSubParcela;
import com.embrapa.mft.repository.consultas.CadSubParcelaRepositoryQuery;

public interface CadSubParcelaRepository extends JpaRepository<CadSubParcela, Long>, CadSubParcelaRepositoryQuery{

}
