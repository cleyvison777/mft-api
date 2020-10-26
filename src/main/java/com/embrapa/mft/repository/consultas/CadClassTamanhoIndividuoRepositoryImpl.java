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

import com.embrapa.mft.model.CadClassTamanhoIndividuo;
import com.embrapa.mft.model.CadClassTamanhoIndividuo_;
import com.embrapa.mft.repository.filter.CadClassTamanhoIndividuoFilter;

public class CadClassTamanhoIndividuoRepositoryImpl implements CadClassTamanhoIndividuoRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<CadClassTamanhoIndividuo> filtrar(CadClassTamanhoIndividuoFilter cadClassTamanhoIndividuoFilter,
			Pageable pageable) {
		
		 CriteriaBuilder builder = manager.getCriteriaBuilder();
		 CriteriaQuery<CadClassTamanhoIndividuo> criteria = builder.createQuery(CadClassTamanhoIndividuo.class);
		 Root<CadClassTamanhoIndividuo> root = criteria.from(CadClassTamanhoIndividuo.class);
		   
		 Predicate[] predicates = criarRestricoes(cadClassTamanhoIndividuoFilter, builder, root);
		 criteria.where(predicates);
		 
		 TypedQuery<CadClassTamanhoIndividuo> query = manager.createQuery(criteria);
		 adiconarRestricoesDePaginacao(query, pageable);
		 
		return new PageImpl<>(query.getResultList(), pageable, total(cadClassTamanhoIndividuoFilter));
	}
	
	 private Long total(CadClassTamanhoIndividuoFilter cadClassTamanhoIndividuoFilter) {
		 CriteriaBuilder builder = manager.getCriteriaBuilder();
		 CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		 Root<CadClassTamanhoIndividuo> root = criteria.from(CadClassTamanhoIndividuo.class);
		 
		 Predicate[] predicates = criarRestricoes(cadClassTamanhoIndividuoFilter, builder, root);
		 criteria.where(predicates);
		 
		 criteria.select(builder.count(root));
		 return manager.createQuery(criteria).getSingleResult(); 
		 
	 }
	

	private Predicate[] criarRestricoes(CadClassTamanhoIndividuoFilter cadClassTamanhoIndividuoFilter, CriteriaBuilder builder,
			Root<CadClassTamanhoIndividuo> root) {
		    List<Predicate> predicates = new ArrayList<>();
		    if(!StringUtils.isEmpty(cadClassTamanhoIndividuoFilter.getNmClasseTamanho())) {
		    	predicates.add(builder.like(
		    			builder.lower(root.get(CadClassTamanhoIndividuo_.nmClasseTamanho)), "%" + cadClassTamanhoIndividuoFilter.getNmClasseTamanho().toLowerCase() + "%"));
		    }
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
		
	}
}
