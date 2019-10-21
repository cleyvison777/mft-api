package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.ListaEspecie;

public interface CadListaEspecieRepository extends JpaRepository<ListaEspecie, Long> {

}
