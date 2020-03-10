package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadGrupoEcologico;
import com.embrapa.mft.repository.consultas.CadGrupoEcologicoRepositoryQuery;

public interface CadGrupoEcologicoRepository extends JpaRepository<CadGrupoEcologico, Long>, CadGrupoEcologicoRepositoryQuery{

}
