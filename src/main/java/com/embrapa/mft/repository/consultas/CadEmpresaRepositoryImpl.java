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

import com.embrapa.mft.model.CadEmpresa;
import com.embrapa.mft.model.CadEmpresa_;
import com.embrapa.mft.repository.filter.CadEmpresaFilter;

public class CadEmpresaRepositoryImpl implements CadEmpresaRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<CadEmpresa> filtrar(CadEmpresaFilter cadEmpresaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<CadEmpresa> criteria = builder .createQuery(CadEmpresa.class);
		Root<CadEmpresa> root = criteria.from(CadEmpresa.class);
		
		Predicate[] predicates = criarRestricoes(cadEmpresaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<CadEmpresa> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(cadEmpresaFilter));
	}

	private Long total(CadEmpresaFilter cadEmpresaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<CadEmpresa> root = criteria.from(CadEmpresa.class);
		
		Predicate[] predicates = criarRestricoes(cadEmpresaFilter, builder, root);
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

	private Predicate[] criarRestricoes(CadEmpresaFilter cadEmpresaFilter, CriteriaBuilder builder,
			Root<CadEmpresa> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(cadEmpresaFilter.getNmEmpresa())) {
			predicates.add(builder.like(
					builder.lower(root.get(CadEmpresa_.nmEmpresa)), "%" + cadEmpresaFilter.getNmEmpresa().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}


}
