package com.embrapa.mft.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.embrapa.mft.model.UsoEspecie;
import com.embrapa.mft.repository.filter.CadUsoEspecieFilter;

public interface CadUsoEspecieRepositoryQuery {
public Page<UsoEspecie> filtrar(CadUsoEspecieFilter cadUsoEspecieFilter, Pageable pageable);
}
