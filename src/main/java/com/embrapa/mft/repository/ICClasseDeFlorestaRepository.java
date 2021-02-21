package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.embrapa.mft.model.ICClasseDeFloresta;
import com.embrapa.mft.repository.consultas.ICClasseDeFlorestaRepositoryQuery;



public interface ICClasseDeFlorestaRepository  extends JpaRepository <ICClasseDeFloresta, Long>, ICClasseDeFlorestaRepositoryQuery{
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE d30_classe_floresta SET  d30_imfigura=:url WHERE d30_cdclassefloresta=:cdClassefloresta", 
			   nativeQuery = true)
	public void atualizarUrlImagem(@Param("cdClassefloresta") ICClasseDeFloresta cdClassefloresta,@Param("url") String url);
	
   

}
