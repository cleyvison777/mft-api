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

import com.embrapa.mft.model.CadTratamentoSilvicultural;
import com.embrapa.mft.model.CadTratamentoSilvicultural_;
import com.embrapa.mft.repository.filter.CadTratamentoSilviculturalFilter;

public class CadTratamentoSilviculturalRepositoryImpl  implements CadTratamentoSilviculturalRepositoryQuery {
  
	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public Page<CadTratamentoSilvicultural> filtrar(CadTratamentoSilviculturalFilter cadTratamentoSilviculturalFilter,
			Pageable pageable) {
		   CriteriaBuilder builder = manager.getCriteriaBuilder();
		   CriteriaQuery<CadTratamentoSilvicultural> criteria = builder.createQuery(CadTratamentoSilvicultural.class);
		   Root<CadTratamentoSilvicultural> root = criteria.from(CadTratamentoSilvicultural.class);
		   
		   Predicate[] predicates = criarRestricoes(cadTratamentoSilviculturalFilter, builder, root);
		   criteria.where(predicates);
		   
		   TypedQuery<CadTratamentoSilvicultural> query = manager.createQuery(criteria);
		   adiconarRestricoesDePaginacao(query, pageable);
		   
		   return new PageImpl<>(query.getResultList(), pageable, total(cadTratamentoSilviculturalFilter));
	}
	
	private Long total(CadTratamentoSilviculturalFilter cadTratamentoSilviculturalFilter) {
		   CriteriaBuilder builder = manager.getCriteriaBuilder();
		   CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		   Root<CadTratamentoSilvicultural> root = criteria.from(CadTratamentoSilvicultural.class);
		   
		   Predicate[] predicates = criarRestricoes(cadTratamentoSilviculturalFilter, builder, root);
		   criteria.where(predicates);
		   
		   criteria.select(builder.count(root));
		   return manager.createQuery(criteria).getSingleResult();
	}
	
	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
		
	}
	
	private Predicate[] criarRestricoes(CadTratamentoSilviculturalFilter cadTratamentoSilviculturalFilter, CriteriaBuilder builder,
			Root<CadTratamentoSilvicultural> root) {
		    List<Predicate> predicates = new ArrayList<>();
		    if(!StringUtils.isEmpty(cadTratamentoSilviculturalFilter.getNmTratamento())) {
		   predicates.add(builder.like(builder.lower(root.get(CadTratamentoSilvicultural_.nmTratamento))
				   , "%" + cadTratamentoSilviculturalFilter.getNmTratamento().toLowerCase() + "%"));
		    }
		    
		    return predicates.toArray(new Predicate[predicates.size()]);
	}

}
