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

import com.embrapa.mft.model.CadGrupoEcologico;
import com.embrapa.mft.model.CadGrupoEcologico_;
import com.embrapa.mft.repository.filter.CadGrupoEcologicoFilter;
public class CadGrupoEcologicoRepositoryImpl  implements CadGrupoEcologicoRepositoryQuery {
	@PersistenceContext
	private EntityManager manager;

	
	
	@Override
	public Page<CadGrupoEcologico> filtrar(CadGrupoEcologicoFilter cadGrupoEcologicoFilter, Pageable pageable) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
	    CriteriaQuery<CadGrupoEcologico> criteria = builder.createQuery(CadGrupoEcologico.class);
	    
	       Root<CadGrupoEcologico> root = criteria.from(CadGrupoEcologico.class);
	       Predicate[] predicates = criarRestricoes(cadGrupoEcologicoFilter, builder, root);
	        criteria.where(predicates);
	           
	          TypedQuery<CadGrupoEcologico> query = manager.createQuery(criteria);
	             adiconarRestricoesDePaginacao(query, pageable);
	                
	          return  new PageImpl<>(query.getResultList(), pageable, total(cadGrupoEcologicoFilter));
}

private Predicate[] criarRestricoes(CadGrupoEcologicoFilter cadGrupoEcologicoFilter, CriteriaBuilder builder,
	   Root<CadGrupoEcologico> root) {
        List<Predicate> predicates = new ArrayList<>();
          if(!StringUtils.isEmpty(cadGrupoEcologicoFilter.getNmGrupoEcologico())) {
        	  predicates.add(builder.like(
        			  root.get(CadGrupoEcologico_.nmGrupoEcologico), "%" + cadGrupoEcologicoFilter.getNmGrupoEcologico().
        			  toLowerCase() + "%"));
          }
          
          return predicates.toArray(new Predicate[predicates.size()]);
}


private Long total (CadGrupoEcologicoFilter cadGrupoEcologicoFilter) {
   CriteriaBuilder builder = manager.getCriteriaBuilder();
   CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
     Root<CadGrupoEcologico> root = criteria.from(CadGrupoEcologico.class);
     
       Predicate[] predicates = criarRestricoes(cadGrupoEcologicoFilter, builder, root);
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
