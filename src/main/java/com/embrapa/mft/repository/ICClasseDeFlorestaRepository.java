package com.embrapa.mft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.embrapa.mft.model.CadAmf;
import com.embrapa.mft.model.ICClasseDeFloresta;
import com.embrapa.mft.repository.consultas.CadAmfRepositoryQuery;
import com.embrapa.mft.repository.consultas.ICClasseDeFlorestaRepositoryQuery;



public interface ICClasseDeFlorestaRepository  extends JpaRepository <ICClasseDeFloresta, Long>, ICClasseDeFlorestaRepositoryQuery
{

}
