package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadArvore;

public interface CadArvoreRepository  extends JpaRepository<CadArvore, Long> {

}
