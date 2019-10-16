package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.ListaEspecie;

public interface MftListaEspecieRepository extends JpaRepository<ListaEspecie, Long> {

}
