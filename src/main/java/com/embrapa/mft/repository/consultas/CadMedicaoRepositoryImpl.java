package com.embrapa.mft.repository.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.embrapa.mft.model.CadMedicao;
import com.embrapa.mft.model.CadMedicao_;
import com.embrapa.mft.model.CadUsoEspecie_;
import com.embrapa.mft.repository.filter.CadMedicaoFilter;

public class CadMedicaoRepositoryImpl implements CadMedicaoRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<CadMedicao> filtrar(CadMedicaoFilter cadMedicaoFilter, Pageable pageable) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
	    CriteriaQuery<CadMedicao> criteria = builder.createQuery(CadMedicao.class);
	    
	    Root<CadMedicao> root = criteria.from(CadMedicao.class);
	    Predicate[] predicates = criarRestricoes(cadMedicaoFilter, builder, root);
	    criteria.where(predicates);
	           
	    TypedQuery<CadMedicao> query = manager.createQuery(criteria);
	    adiconarRestricoesDePaginacao(query, pageable);
	                
	    return  new PageImpl<>(query.getResultList(), pageable, total(cadMedicaoFilter));
	}

	private Long total(CadMedicaoFilter cadMedicaoFilter) {
		 CriteriaBuilder builder = manager.getCriteriaBuilder();
		   CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		  Root<CadMedicao> root = criteria.from(CadMedicao.class);
		     
		 Predicate[] predicates = criarRestricoes(cadMedicaoFilter, builder, root);
		 criteria.where(predicates);
		 criteria.select(builder.count(root));
		 return manager.createQuery(criteria).getSingleResult();
	}

	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual =  pageable.getPageNumber();
		  int totalDeRegistrosPorPagina =  pageable.getPageSize();
		  int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		  
		    query.setFirstResult(primeiroRegistroDaPagina);
			query.setMaxResults(totalDeRegistrosPorPagina);
		
	}

	private Predicate[] criarRestricoes(CadMedicaoFilter cadMedicaoFilter, CriteriaBuilder builder,
			Root<CadMedicao> root) {
		  List<Predicate> predicates = new ArrayList<>();
          if(!StringUtils.isEmpty(cadMedicaoFilter.getTxObservacao())) {
        	  predicates.add(builder.like(
        			  root.get(CadMedicao_.txObservacao), "%" + cadMedicaoFilter.getTxObservacao().
        			  toLowerCase() + "%"));
          }if (cadMedicaoFilter.getCdEmpresa() != null) {
				predicates.add(
						builder.equal(root.get(CadMedicao_.cdEmpresa), cadMedicaoFilter.getCdEmpresa()));
          }
          
          return predicates.toArray(new Predicate[predicates.size()]);
	}

}
