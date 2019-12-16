package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadEmpresa;
import com.embrapa.mft.repository.consultas.CadEmpresaRepositoryQuery;

public interface CadEmpresaRepository  extends JpaRepository<CadEmpresa, Long>, CadEmpresaRepositoryQuery{


}
