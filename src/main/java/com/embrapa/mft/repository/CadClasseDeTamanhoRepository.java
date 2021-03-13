package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadClasseDeTamanho;
import com.embrapa.mft.repository.consultas.CadClasseDeTamanhoRepositoryQuery;
;

public interface CadClasseDeTamanhoRepository extends JpaRepository<CadClasseDeTamanho, Long>, CadClasseDeTamanhoRepositoryQuery {

}
