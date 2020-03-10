package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadGrupoEcologico;
import com.embrapa.mft.repository.filter.CadGrupoEcologicoFilter;

public interface CadGrupoEcologicoRepositoryQuery {
public Page<CadGrupoEcologico> filtrar(CadGrupoEcologicoFilter cadGrupoEcologicoFilter, Pageable pageable);

 }
