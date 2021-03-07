package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadParcela;
import com.embrapa.mft.repository.consultas.CadParcelaRepositoryQuery;

public interface CadParcelaRepository extends JpaRepository<CadParcela, Long>, CadParcelaRepositoryQuery{

}
