package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embrapa.mft.model.ParcelaMft;

public interface CadParcelaRepository extends JpaRepository<ParcelaMft, Long>{

}
