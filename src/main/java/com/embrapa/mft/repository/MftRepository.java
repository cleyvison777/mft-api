package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.CadEmpresa;

public interface MftRepository  extends JpaRepository<CadEmpresa, Long>{

}
