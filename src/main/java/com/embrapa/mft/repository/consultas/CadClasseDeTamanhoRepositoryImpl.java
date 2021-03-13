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

import com.embrapa.mft.model.CadClasseDeTamanho;
import com.embrapa.mft.model.CadClasseDeTamanho_;
import com.embrapa.mft.repository.filter.CadClasseDeTamanhoFilter;


public class CadClasseDeTamanhoRepositoryImpl implements CadClasseDeTamanhoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<CadClasseDeTamanho> filtrar(CadClasseDeTamanhoFilter cadClasseDeTamanhoFilter,
			Pageable pageable) {
		
		 CriteriaBuilder builder = manager.getCriteriaBuilder();
		 CriteriaQuery<CadClasseDeTamanho> criteria = builder.createQuery(CadClasseDeTamanho.class);
		 Root<CadClasseDeTamanho> root = criteria.from(CadClasseDeTamanho.class);
		   
		 Predicate[] predicates = criarRestricoes(cadClasseDeTamanhoFilter, builder, root);
		 criteria.where(predicates);
		 
		 TypedQuery<CadClasseDeTamanho> query = manager.createQuery(criteria);
		 adiconarRestricoesDePaginacao(query, pageable);
		 
		return new PageImpl<>(query.getResultList(), pageable, total(cadClasseDeTamanhoFilter));
	}
	
	 private Long total(CadClasseDeTamanhoFilter cadClasseDeTamanhoFilter) {
		 CriteriaBuilder builder = manager.getCriteriaBuilder();
		 CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		 Root<CadClasseDeTamanho> root = criteria.from(CadClasseDeTamanho.class);
		 
		 Predicate[] predicates = criarRestricoes(cadClasseDeTamanhoFilter, builder, root);
		 criteria.where(predicates);
		 
		 criteria.select(builder.count(root));
		 return manager.createQuery(criteria).getSingleResult(); 
		 
	 }
	

	private Predicate[] criarRestricoes(CadClasseDeTamanhoFilter cadClasseDeTamanhoFilter, CriteriaBuilder builder,
			Root<CadClasseDeTamanho> root) {
		    List<Predicate> predicates = new ArrayList<>();
		    if (cadClasseDeTamanhoFilter.getCdArea() != null) {
				predicates.add(
						builder.equal(root.get(CadClasseDeTamanho_.cdEmpresa), cadClasseDeTamanhoFilter.getCdArea()));
            }if (cadClasseDeTamanhoFilter.getCdEmpresa() != null) {
				predicates.add(
						builder.equal(root.get(CadClasseDeTamanho_.cdEmpresa), cadClasseDeTamanhoFilter.getCdEmpresa()));
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
