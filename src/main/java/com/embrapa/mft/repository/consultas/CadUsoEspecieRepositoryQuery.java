package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.CadUsoEspecie;
import com.embrapa.mft.repository.filter.CadUsoEspecieFilter;

public interface CadUsoEspecieRepositoryQuery {
public Page<CadUsoEspecie> filtrar(CadUsoEspecieFilter cadUsoEspecieFilter, Pageable pageable);
}
