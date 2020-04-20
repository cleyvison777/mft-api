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

import com.embrapa.mft.model.CadFamilia;
import com.embrapa.mft.model.CadFamilia_;
import com.embrapa.mft.repository.filter.CadFamiliaFilter;

public class CadFamiliaRepositoryImpl  implements CadFamiliaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<CadFamilia> filtrar(CadFamiliaFilter cadFamiliaFilter,Pageable pageable) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<CadFamilia> criteria = builder .createQuery(CadFamilia.class);
		Root<CadFamilia> root = criteria.from(CadFamilia.class);
		  
		Predicate[] predicates = criarRestricoes(cadFamiliaFilter, builder, root);
		criteria.where(predicates);
		     TypedQuery<CadFamilia> query = manager.createQuery(criteria);
		     adiconarRestricoesDePaginacao(query, pageable);    
		     
		return new PageImpl<>(query.getResultList(), pageable, total(cadFamiliaFilter));
		
		
		
	}


	  private Predicate[] criarRestricoes(CadFamiliaFilter cadFamiliaFilter, CriteriaBuilder builder,
			  Root<CadFamilia> root) {
		  List<Predicate> predicates = new ArrayList<>();
		    if(!StringUtils.isEmpty(cadFamiliaFilter.getNmFamilia())) {
		    	predicates.add(builder.like(builder.lower(root.get(CadFamilia_.nmFamilia)), "%" + 
		    cadFamiliaFilter.getNmFamilia().toLowerCase()+ "%"));
		    }
		  
		  return predicates.toArray(new Predicate[predicates.size()]);
	  }
	  
	  private Long total (CadFamiliaFilter cadFamiliaFilter) {
		  CriteriaBuilder builder = manager.getCriteriaBuilder();
		  CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		  Root<CadFamilia> root = criteria.from(CadFamilia.class);
		  
		  Predicate[] predicates = criarRestricoes(cadFamiliaFilter, builder, root);
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
	  
	 
}



