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

import com.embrapa.mft.model.UsoEspecie;
import com.embrapa.mft.model.UsoEspecie_;
import com.embrapa.mft.repository.filter.CadUsoEspecieFilter;

import br.embrapa.model.CadMaterial_;

public class CadUsoEspecieRepositoryImpl  implements  CadUsoEspecieRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	@Override
	public Page<UsoEspecie> filtrar(CadUsoEspecieFilter cadUsoEspecieFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		 CriteriaQuery<UsoEspecie> criteria = builder .createQuery(UsoEspecie.class);
		  Root<UsoEspecie> root = criteria.from(UsoEspecie.class);
		     
		   Predicate[] predicates = criarRestricoes(cadUsoEspecieFilter, builder, root);
		    criteria.where(predicates);
		    
		     TypedQuery<UsoEspecie> query = manager.createQuery(criteria);
		      adiconarRestricoesDePaginacao(query, pageable);
		        return new PageImpl<>(query.getResultList(), pageable, total(cadUsoEspecieFilter));
	}
	
	 private Long total(CadUsoEspecieFilter cadUsoEspecieFilter) {
		 CriteriaBuilder builder = manager.getCriteriaBuilder();
		  CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		   Root<UsoEspecie> root = criteria.from(UsoEspecie.class);
		   
		   Predicate[] predicates = criarRestricoes(cadUsoEspecieFilter, builder, root);
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
      
	private Predicate[] criarRestricoes(CadUsoEspecieFilter cadUsoEspecieFilter, CriteriaBuilder builder,
			Root<UsoEspecie> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		 if(!StringUtils.isEmpty(cadUsoEspecieFilter.getNmUso())) {
			 predicates.add(builder.like(
					 builder.lower(root.get(UsoEspecie_.nmUso)), "%" + cadUsoEspecieFilter.getNmUso()
			 .toLowerCase() + "%"));
		 }
		 if (cadUsoEspecieFilter.getCdEmpresa() != null) {
				predicates.add(
						builder.equal(root.get(UsoEspecie_.cdEmpresa), cadUsoEspecieFilter.getCdEmpresa()));
			}
		return predicates.toArray( new Predicate[predicates.size()]);
		 
	}
	
	
}
