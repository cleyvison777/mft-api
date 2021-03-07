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

import com.embrapa.mft.model.CadParcela;
import com.embrapa.mft.model.CadParcela_;
import com.embrapa.mft.repository.filter.CadParcelaFilter;


public class CadParcelaRepositoryImpl implements CadParcelaRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<CadParcela> filtrar(CadParcelaFilter cadParcelaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<CadParcela> criteria = builder .createQuery(CadParcela.class);
		Root<CadParcela> root = criteria.from(CadParcela.class);
		
		Predicate[] predicates = criarRestricoes(cadParcelaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<CadParcela> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(cadParcelaFilter));
	}

	private Long total(CadParcelaFilter cadParcelaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<CadParcela> root = criteria.from(CadParcela.class);
		
		Predicate[] predicates = criarRestricoes(cadParcelaFilter, builder, root);
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

	private Predicate[] criarRestricoes(CadParcelaFilter cadParcelaFilter, CriteriaBuilder builder,
			Root<CadParcela> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(cadParcelaFilter.getTxObservacoesParcela())) {
			predicates.add(builder.like(
					builder.lower(root.get(CadParcela_.txObservacoesParcela)), "%" + cadParcelaFilter.getTxObservacoesParcela().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
