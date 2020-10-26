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

import com.embrapa.mft.model.CadTsAtualTsAnterior;
import com.embrapa.mft.model.CadTsAtualTsAnterior_;
import com.embrapa.mft.repository.filter.CadTsAtualTsAnteriorFilter;


public class CadTsAtualTsAnteriorRepositoryImpl implements CadTsAtualTsAnteriorRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<CadTsAtualTsAnterior> filtrar(CadTsAtualTsAnteriorFilter cadTsAtualTsAnteriorFilter,
			Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<CadTsAtualTsAnterior> critetia = builder.createQuery(CadTsAtualTsAnterior.class);
		Root<CadTsAtualTsAnterior> root = critetia.from(CadTsAtualTsAnterior.class);
		
		Predicate[] predicates = criarRestricoes(cadTsAtualTsAnteriorFilter, builder, root);
		critetia.where(predicates);
		
		TypedQuery<CadTsAtualTsAnterior> query = manager.createQuery(critetia);
		adiconarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(cadTsAtualTsAnteriorFilter));
	}

	private Long total(CadTsAtualTsAnteriorFilter cadTsAtualTsAnteriorFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> critetia = builder.createQuery(Long.class);
		Root<CadTsAtualTsAnterior> root = critetia.from(CadTsAtualTsAnterior.class);
		
		Predicate[] predicates = criarRestricoes(cadTsAtualTsAnteriorFilter, builder, root);
		critetia.where(predicates);
		
		critetia.select(builder.count(root));
		return manager.createQuery(critetia).getSingleResult();
	}
	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
		
	}
	
	private Predicate[] criarRestricoes(CadTsAtualTsAnteriorFilter cadTsAtualTsAnteriorFilter, CriteriaBuilder builder,
			Root<CadTsAtualTsAnterior> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if (cadTsAtualTsAnteriorFilter.getCdTratamentoAnteriorPk() != 0) {
			predicates.add(builder.equal(root.get(CadTsAtualTsAnterior_.cdTratamentoAnteriorPk), cadTsAtualTsAnteriorFilter.getCdTratamentoAnteriorPk()));
		}
		
		if (cadTsAtualTsAnteriorFilter.getCdTratamentotual() != null) {
			predicates.add(builder.equal(root.get(CadTsAtualTsAnterior_.cdTratamentotual), cadTsAtualTsAnteriorFilter.getCdTratamentotual()));
		}
		
		if(cadTsAtualTsAnteriorFilter.getCdEmpresa() != null){
				predicates.add(builder.equal(root.get(CadTsAtualTsAnterior_.cdEmpresa), cadTsAtualTsAnteriorFilter.getCdEmpresa()));
			}
		if(cadTsAtualTsAnteriorFilter.getCdTratamentoAnterior()!= null) {
			predicates.add(builder.equal(root.get(CadTsAtualTsAnterior_.cdTratamentoAnterior), cadTsAtualTsAnteriorFilter.getCdTratamentoAnterior()));
		}
		
		
		return predicates.toArray(new Predicate[predicates.size()]) ;
	}
	
}



