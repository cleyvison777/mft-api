package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.TipoParcelaMft;

public interface CadTipoParcelaRepository extends JpaRepository<TipoParcelaMft, Long>{

}
