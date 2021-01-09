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

import com.embrapa.mft.model.ICClasseDeFloresta;
import com.embrapa.mft.model.ICClasseDeFloresta_;
import com.embrapa.mft.repository.filter.ICClasseDeFlorestaFilter;


public class ICClasseDeFlorestaRepositoryImpl  implements  ICClasseDeFlorestaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	@Override
	public Page<ICClasseDeFloresta> filtrar(ICClasseDeFlorestaFilter cadICClasseDeFlorestaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		 CriteriaQuery<ICClasseDeFloresta> criteria = builder .createQuery(ICClasseDeFloresta.class);
		  Root<ICClasseDeFloresta> root = criteria.from(ICClasseDeFloresta.class);
		     
		   Predicate[] predicates = criarRestricoes(cadICClasseDeFlorestaFilter, builder, root);
		    criteria.where(predicates);
		    
		     TypedQuery<ICClasseDeFloresta> query = manager.createQuery(criteria);
		      adiconarRestricoesDePaginacao(query, pageable);
		        return new PageImpl<>(query.getResultList(), pageable, total(cadICClasseDeFlorestaFilter));
	}
	
	 private Long total(ICClasseDeFlorestaFilter iCClasseDeFlorestaFilter) {
		 CriteriaBuilder builder = manager.getCriteriaBuilder();
		  CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		   Root<ICClasseDeFloresta> root = criteria.from(ICClasseDeFloresta.class);
		   
		   Predicate[] predicates = criarRestricoes(iCClasseDeFlorestaFilter, builder, root);
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
      
	private Predicate[] criarRestricoes(ICClasseDeFlorestaFilter iCClasseDeFlorestaFilter, CriteriaBuilder builder,
			Root<ICClasseDeFloresta> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if (iCClasseDeFlorestaFilter.getCdClassefloresta() != null) {
				predicates.add(
						builder.equal(root.get(ICClasseDeFloresta_.cdClassefloresta), iCClasseDeFlorestaFilter.getCdClassefloresta()));
		}
		
		 return predicates.toArray( new Predicate[predicates.size()]);
		 
	}
	
	
}
