package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.UsoEspecie;
import com.embrapa.mft.repository.consultas.CadUsoEspecieRepositoryQuery;

public interface CadUsoEspecieRepository extends JpaRepository<UsoEspecie, Long>, CadUsoEspecieRepositoryQuery {

}
