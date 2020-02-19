package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadFamilia;
import com.embrapa.mft.repository.consultas.CadFamiliaRepositoryQuery;

public interface CadFamiliaRepository  extends JpaRepository<CadFamilia, Long>, CadFamiliaRepositoryQuery{

}
