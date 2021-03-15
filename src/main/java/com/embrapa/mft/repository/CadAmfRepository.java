package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.embrapa.mft.model.CadAmf;
import com.embrapa.mft.repository.consultas.CadAmfRepositoryQuery;


public interface CadAmfRepository  extends JpaRepository <CadAmf, Long>, CadAmfRepositoryQuery{

}
