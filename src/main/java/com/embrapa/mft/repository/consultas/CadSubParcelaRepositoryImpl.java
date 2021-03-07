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

import com.embrapa.mft.model.CadSubParcela;
import com.embrapa.mft.model.CadSubParcela_;
import com.embrapa.mft.repository.filter.CadSubParcelaFilter;

public class CadSubParcelaRepositoryImpl implements CadSubParcelaRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<CadSubParcela> filtrar(CadSubParcelaFilter cadSubParcelaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<CadSubParcela> criteria = builder .createQuery(CadSubParcela.class);
		Root<CadSubParcela> root = criteria.from(CadSubParcela.class);
		
		Predicate[] predicates = criarRestricoes(cadSubParcelaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<CadSubParcela> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(cadSubParcelaFilter));
	}

	private Long total(CadSubParcelaFilter cadSubParcelaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<CadSubParcela> root = criteria.from(CadSubParcela.class);
		
		Predicate[] predicates = criarRestricoes(cadSubParcelaFilter, builder, root);
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

	private Predicate[] criarRestricoes(CadSubParcelaFilter cadSubParcelaFilter, CriteriaBuilder builder,
			Root<CadSubParcela> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		if (cadSubParcelaFilter.getCdEmpresa() != null) {
			predicates.add(
					builder.equal(root.get(CadSubParcela_.cdEmpresa), cadSubParcelaFilter.getCdEmpresa()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
