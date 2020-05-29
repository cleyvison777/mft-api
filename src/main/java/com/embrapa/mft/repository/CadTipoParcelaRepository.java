package com.embrapa.mft.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.embrapa.mft.model.CadTipoParcela;
import com.embrapa.mft.repository.consultas.CadTipoParcelaRepositoryQuery;

public interface CadTipoParcelaRepository extends JpaRepository<CadTipoParcela, Long>, CadTipoParcelaRepositoryQuery {


	
}
