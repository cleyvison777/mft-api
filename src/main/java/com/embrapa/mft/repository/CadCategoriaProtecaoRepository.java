
package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.embrapa.mft.model.CadCategoriaProtecao;
import com.embrapa.mft.repository.consultas.CadCategoriaProtecaoRepositoryQuery;

public interface CadCategoriaProtecaoRepository  extends JpaRepository<CadCategoriaProtecao, Long>, CadCategoriaProtecaoRepositoryQuery{

	
}
