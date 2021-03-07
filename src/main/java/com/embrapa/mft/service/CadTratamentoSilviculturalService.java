package com.embrapa.mft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.embrapa.mft.model.CadTratamentoSilvicultural;
import com.embrapa.mft.model.CadUsoEspecie;
import com.embrapa.mft.repository.CadTratamentoSilviculturalRepository;

@Service
public class CadTratamentoSilviculturalService {
	@Autowired
	private CadTratamentoSilviculturalRepository cadTratamentoSilviculturalRepository;
	
	/*
	 * public CadTratamentoSilvicultural salvar(CadTratamentoSilvicultural
	 * cadTratamentoSilvicultural) {
	 * cadTratamentoSilvicultural.getCdTratamentAnterior().forEach(c ->
	 * c.setCdTratamento(cadTratamentoSilvicultural)); return
	 * cadTratamentoSilviculturalRepository.save(cadTratamentoSilvicultural); }
	 * 
	 * public CadTratamentoSilvicultural atualizar(Long codigo,
	 * CadTratamentoSilvicultural cadTratamentoSilvicultural) {
	 * CadTratamentoSilvicultural cadTratamentoSilviculturalSalva =
	 * buscarTratamentoSilviculturalPeloCodigo(codigo);
	 * 
	 * cadTratamentoSilviculturalSalva.getCdTratamentAnterior().clear();
	 * cadTratamentoSilviculturalSalva.getCdTratamentAnterior().addAll(
	 * cadTratamentoSilvicultural.getCdTratamentAnterior());
	 * cadTratamentoSilviculturalSalva.getCdTratamentAnterior().forEach(c ->
	 * c.setCdTratamento(cadTratamentoSilviculturalSalva));
	 * 
	 * BeanUtils.copyProperties(cadTratamentoSilvicultural,
	 * cadTratamentoSilviculturalSalva, "codigo", "cadTsAtualTsAnterior"); return
	 * cadTratamentoSilviculturalRepository.save(cadTratamentoSilviculturalSalva);
	 * 
	 * }
	 */
	
	public CadTratamentoSilvicultural atualizar(Long cdTratamento, CadTratamentoSilvicultural cadTratamentoSilvicultural) {
		CadTratamentoSilvicultural cadTratamentoSilviculturalSalva = buscarTratamentoSilviculturalPeloCodigo(cdTratamento);
		BeanUtils.copyProperties(cadTratamentoSilvicultural, cadTratamentoSilviculturalSalva, "codigo");
		  return cadTratamentoSilviculturalRepository.save(cadTratamentoSilviculturalSalva);
	}
	
	public CadTratamentoSilvicultural buscarTratamentoSilviculturalPeloCodigo(Long cdTratamento) {
		CadTratamentoSilvicultural cadTratamentoSilviculturalSalva = cadTratamentoSilviculturalRepository.findOne(cdTratamento);
		 if(cadTratamentoSilviculturalSalva == null) {
			 throw new EmptyResultDataAccessException(1);
		 }
		 return cadTratamentoSilviculturalSalva;
	}

}
