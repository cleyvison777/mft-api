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

import com.embrapa.mft.model.Genero;
import com.embrapa.mft.model.Genero_;
import com.embrapa.mft.repository.filter.CadGeneroFilter;

public class CadGeneroRepositoryImpl implements CadGeneroRepositoryQuery{
	
@PersistenceContext
private EntityManager manager;
	
	@Override
	public Page<Genero> filtrar(CadGeneroFilter generoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Genero> criteria = builder .createQuery(Genero.class);
		Root<Genero> root = criteria.from(Genero.class);
	    Predicate[] predicates = criarRestricoes(generoFilter, builder, root);
	       criteria.where(predicates);
	       
	        TypedQuery<Genero> query = manager.createQuery(criteria);
	        adiconarRestricoesDePaginacao(query, pageable);
	        
	         return new PageImpl<>(query.getResultList(), pageable, total(generoFilter));
		
	}
	
	private Predicate[] criarRestricoes(CadGeneroFilter generoFilter, CriteriaBuilder builder,
			   Root<Genero> root) {
		   List<Predicate> predicates = new ArrayList<>();
		    if(!StringUtils.isEmpty(generoFilter.getNmGenero())) {
		    	predicates.add(builder.like(
		    			builder.lower(root.get(Genero_.nmGenero)), "%" + generoFilter.getNmGenero().toLowerCase() + "%"));
		    }
		    
		    return predicates.toArray(new Predicate[predicates.size()]);
	     }
	   
	   private Long total (CadGeneroFilter generoFilter) {
		   CriteriaBuilder builder =  manager.getCriteriaBuilder();
		    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		     Root<Genero> root =  criteria.from(Genero.class);
		    
		     Predicate[] predicates = criarRestricoes(generoFilter, builder, root);
		      criteria.where(predicates);
		        
		        criteria.select(builder.count(root));
		         return manager.createQuery(criteria).getSingleResult();
		        
	   }
	   
	   private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		      int paginaAtual =  pageable.getPageNumber();
			  int totalDeRegistrosPorPagina =  pageable.getPageSize();
			  int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
			  
			    query.setFirstResult(primeiroRegistroDaPagina);
				query.setMaxResults(totalDeRegistrosPorPagina);
	    }
	   

}
