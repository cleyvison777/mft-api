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

import com.embrapa.mft.model.MenuEmpresa;
import com.embrapa.mft.repository.filter.MenuEmpresaFilter;



public class MenuEmpresaRepositoryImpl implements MenuEmpresaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	
		
	@Override
	public Page<MenuEmpresa> filtrar(MenuEmpresaFilter menuEmpresaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<MenuEmpresa>  criteria = builder .createQuery(MenuEmpresa.class);
		Root<MenuEmpresa> root = criteria.from(MenuEmpresa.class);

		Predicate[] predicates = criarRestricoes(menuEmpresaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<MenuEmpresa> query = manager.createQuery(criteria);
		
		adiconarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(menuEmpresaFilter));
	}                                    

	private Long total(MenuEmpresaFilter menuEmpresaFilter){
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<MenuEmpresa> root = criteria.from(MenuEmpresa.class);
		
		Predicate[] predicates = criarRestricoes(menuEmpresaFilter, builder, root);
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
	
	
	private Predicate[] criarRestricoes(MenuEmpresaFilter menuEmpresaFilter, CriteriaBuilder builder,
			Root<MenuEmpresa> root) {
		List<Predicate> predicates = new ArrayList<>();
		/*
		 * if(!StringUtils.isEmpty(menuEmpresaFilter.getNmEmpresa())) {
		 * predicates.add(builder.like( builder.lower(root.get(MenuEmpresa_.nmEmpresa)),
		 * "%" + menuEmpresaFilter.getNmEmpresa().toLowerCase() + "%")); }
		 */
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}


		

	
	
	
}
