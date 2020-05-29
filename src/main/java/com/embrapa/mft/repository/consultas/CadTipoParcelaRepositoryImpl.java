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

import com.embrapa.mft.model.CadTipoParcela;
import com.embrapa.mft.model.CadTipoParcela_;
import com.embrapa.mft.repository.filter.CadTipoParcelaFilter;


public class CadTipoParcelaRepositoryImpl  implements CadTipoParcelaRepositoryQuery{

	
	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public Page<CadTipoParcela> filtrar(CadTipoParcelaFilter cadTipoParcelaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<CadTipoParcela> criteria = builder.createQuery(CadTipoParcela.class);
		Root<CadTipoParcela> root = criteria.from(CadTipoParcela.class);
		Predicate[] predicates = criarRestricoes(cadTipoParcelaFilter, builder, root);
		  criteria.where(predicates);
		  
		  TypedQuery<CadTipoParcela> query = manager.createQuery(criteria);
		   adicionarRestricoesDePaginacao(query, pageable);
		   
	
		  return new PageImpl<>(query.getResultList(), pageable, total(cadTipoParcelaFilter));
	}
	
	private Long total (CadTipoParcelaFilter cadTipoParcelaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<CadTipoParcela> root = criteria.from(CadTipoParcela.class);
		
		Predicate[] predicates = criarRestricoes(cadTipoParcelaFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
		
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
		
	}
	
	private Predicate[] criarRestricoes (CadTipoParcelaFilter cadTipoParcelaFilter, CriteriaBuilder builder,
			Root<CadTipoParcela> root) {
		
		List<Predicate> predicate = new ArrayList<>();
		if(!StringUtils.isEmpty(cadTipoParcelaFilter.getNmTipoParcela())) {
			predicate.add(builder.like(
					builder.lower(root.get(CadTipoParcela_.nmTipoParcela)), "%" + cadTipoParcelaFilter.getNmTipoParcela().toLowerCase()+ "%"));                 
		}
		
		return predicate.toArray(new Predicate[predicate.size()]);
	}

}
