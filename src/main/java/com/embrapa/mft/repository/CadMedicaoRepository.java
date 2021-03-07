package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadMedicao;
import com.embrapa.mft.repository.consultas.CadMedicaoRepositoryQuery;

public interface CadMedicaoRepository extends JpaRepository<CadMedicao, Long>, CadMedicaoRepositoryQuery {

}
