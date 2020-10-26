package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.MenuEmpresa;
import com.embrapa.mft.repository.consultas.MenuEmpresaRepositoryQuery;

public interface MenuEmpresaRepository extends JpaRepository<MenuEmpresa, Long>, MenuEmpresaRepositoryQuery{

}
