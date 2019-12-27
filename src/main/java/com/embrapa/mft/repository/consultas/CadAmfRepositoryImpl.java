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

import com.embrapa.mft.model.CadAmf;
import com.embrapa.mft.model.CadAmf_;
import com.embrapa.mft.repository.filter.CadAmfFilter;

public class CadAmfRepositoryImpl implements CadAmfRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<CadAmf> filtrar(CadAmfFilter cadEmpresaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<CadAmf> criteria = builder .createQuery(CadAmf.class);
		Root<CadAmf> root = criteria.from(CadAmf.class);
		
		Predicate[] predicates = criarRestricoes(cadEmpresaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<CadAmf> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(cadEmpresaFilter));
	}
	
	
	private Long total(CadAmfFilter cadAmfFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<CadAmf> root = criteria.from(CadAmf.class);
		
		Predicate[] predicates = criarRestricoes(cadAmfFilter, builder, root);
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
	
	private Predicate[] criarRestricoes(CadAmfFilter cadAmfFilter, CriteriaBuilder builder,
			Root<CadAmf> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(cadAmfFilter.getNmArea())) {
			predicates.add(builder.like(
					builder.lower(root.get(CadAmf_.nmArea)), "%" + cadAmfFilter.getNmArea().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
