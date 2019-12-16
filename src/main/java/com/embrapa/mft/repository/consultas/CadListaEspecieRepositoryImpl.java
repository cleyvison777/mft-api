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

import com.embrapa.mft.model.CadListaEspecie;
import com.embrapa.mft.model.CadListaEspecie_;
import com.embrapa.mft.repository.filter.CadListaEspecieFilter;

public class CadListaEspecieRepositoryImpl implements CadListaEspecieRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<CadListaEspecie> filtrar(CadListaEspecieFilter cadListaEspecieFilter, Pageable pageable) {
		CriteriaBuilder builder =  manager.getCriteriaBuilder();
		 CriteriaQuery<CadListaEspecie> criteria = builder .createQuery(CadListaEspecie.class);
		   Root<CadListaEspecie> root = criteria.from(CadListaEspecie.class);
		   
		    Predicate[] predicates = criarRestricoes(cadListaEspecieFilter, builder, root);
		     criteria.where(predicates);
		     
		       TypedQuery<CadListaEspecie> query = manager.createQuery(criteria);
		        adicionarRestricoesDePaginacao(query, pageable);
		       
		         return new PageImpl<>(query.getResultList(), pageable, total(cadListaEspecieFilter));
	}

	private Long total(CadListaEspecieFilter cadListaEspecieFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<CadListaEspecie> root = criteria.from(CadListaEspecie.class);
		
		Predicate[] predicates = criarRestricoes(cadListaEspecieFilter, builder, root);
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

	private Predicate[] criarRestricoes(CadListaEspecieFilter cadListaEspecieFilter, CriteriaBuilder builder,	
			  Root<CadListaEspecie> root){
				
				  List<Predicate> predicate = new ArrayList<>();
				  if(!StringUtils.isEmpty(cadListaEspecieFilter.getNmListaEsp())) {
					  predicate.add(builder.like(
							  builder.lower(root.get(CadListaEspecie_.nmListaEsp)), "%" + cadListaEspecieFilter.getNmListaEsp().toLowerCase() + "%"));
				  }
				  
				  return predicate.toArray(new Predicate[predicate.size()]);
			  }
	
}
