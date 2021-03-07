package com.embrapa.mft.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.embrapa.mft.model.CadUsoEspecie;
import com.embrapa.mft.repository.consultas.CadUsoEspecieRepositoryQuery;

public interface CadUsoEspecieRepository extends JpaRepository<CadUsoEspecie, Long>, CadUsoEspecieRepositoryQuery {

	
	@Query(value = "select * from d07_uso_especie where d07_cdempresa =1", 
		   nativeQuery = true)
	List<CadUsoEspecie> listarDadosPadrao();
	
	@Transactional
	@Modifying
	@Query(value ="INSERT INTO d07_uso_especie(d07_cdempresa, d07_nmuso, d07_lgmadeira) VALUES (:cdempresa, :nmuso, :lgmadeira)", 
			   nativeQuery = true)
	void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
			@Param("nmuso") String nmuso, @Param("lgmadeira") String lgmadeira);
	
   }
