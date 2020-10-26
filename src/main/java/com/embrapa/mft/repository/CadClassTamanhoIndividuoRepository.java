package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadClassTamanhoIndividuo;
import com.embrapa.mft.repository.consultas.CadClassTamanhoIndividuoRepositoryQuery;

public interface CadClassTamanhoIndividuoRepository extends JpaRepository<CadClassTamanhoIndividuo, Long>, CadClassTamanhoIndividuoRepositoryQuery{

}
