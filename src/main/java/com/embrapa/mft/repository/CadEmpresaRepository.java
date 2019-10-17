package com.embrapa.mft.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadEmpresa;
import com.embrapa.mft.repository.consultas.CadEmpresaRepositoryQuery;
import com.embrapa.mft.repository.filter.CadEmpresaFilter;

public interface CadEmpresaRepository  extends JpaRepository<CadEmpresa, Long>, CadEmpresaRepositoryQuery{


}
