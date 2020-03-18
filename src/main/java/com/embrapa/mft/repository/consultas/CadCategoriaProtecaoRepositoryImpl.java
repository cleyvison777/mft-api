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

import com.embrapa.mft.model.CadCategoriaProtecao;
import com.embrapa.mft.model.CadCategoriaProtecao_;
import com.embrapa.mft.repository.filter.CadCategoriaProtecaoFilter;

public class CadCategoriaProtecaoRepositoryImpl implements CadCategoriaProtecaoRepositoryQuery{
@PersistenceContext
private EntityManager manager;

	
	@Override
	public Page<CadCategoriaProtecao> filtrar(CadCategoriaProtecaoFilter cadCategoriaProtecaoFilter,
			Pageable pageable) {
	  CriteriaBuilder builder = manager.getCriteriaBuilder();
	   CriteriaQuery<CadCategoriaProtecao> criteria = builder .createQuery(CadCategoriaProtecao.class);
	      Root<CadCategoriaProtecao> root = criteria.from(CadCategoriaProtecao.class);
	        Predicate[] predicates = criarRestricoes(cadCategoriaProtecaoFilter, builder, root);
	         criteria.where(predicates);
	            
	           TypedQuery<CadCategoriaProtecao> query = manager.createQuery(criteria);
	            adiconarRestricoesDePaginacao(query, pageable);
	                return new PageImpl<>(query.getResultList(), pageable, total(cadCategoriaProtecaoFilter));
	}
	
	private Predicate[] criarRestricoes(CadCategoriaProtecaoFilter cadCategoriaProtecaoFilter, CriteriaBuilder builder,
			 Root<CadCategoriaProtecao> root) {
		List<Predicate> predicates =  new ArrayList<>();
		 if(!StringUtils.isEmpty(cadCategoriaProtecaoFilter.getNmCategoriaProtecao())) {
			 predicates.add(builder.like(builder.lower(root.get(CadCategoriaProtecao_.nmCategoriaProtecao)), "%" 
					  + cadCategoriaProtecaoFilter.getNmCategoriaProtecao().toLowerCase()+ "%"));
		  }
		 
		 return predicates.toArray(new Predicate[predicates.size()]);
		 
	}
	
	private Long total(CadCategoriaProtecaoFilter cadCategoriaProtecaoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		 CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		   Root<CadCategoriaProtecao> root = criteria.from(CadCategoriaProtecao.class);
		    
		    Predicate[] predicates = criarRestricoes(cadCategoriaProtecaoFilter, builder, root);
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
