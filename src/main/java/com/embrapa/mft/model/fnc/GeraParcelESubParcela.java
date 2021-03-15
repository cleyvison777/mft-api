package com.embrapa.mft.model.fnc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "geraparcelasubparcela")
public class GeraParcelESubParcela {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="cdempresa")
	private Long cdEmpresa;
	
	@Column(name="cdarea")
	private Long cdArea;
	
	@Column(name="cdparcelainicio")
	private Integer cdParcelaInicio;
	
	@Column(name="nrparcelas")
	private Integer nrParcelas;
	
	@Column(name="nrsubparcelas")
	private Integer nrSubParcelasPorParcelas;
	
	@Column(name="cdtipoparcela")
	private Long cdTipoParcela;
	
	
		
	@Override
	public String toString() {
		return "GeraParcelESubParcelaDTO [cdEmpresa=" + cdEmpresa + ", cdArea=" + cdArea + ", cdParcelaInicio="
				+ cdParcelaInicio + ", nrParcelas=" + nrParcelas + ", nrSubParcelasPorParcelas="
				+ nrSubParcelasPorParcelas + ", cdTipoParcela=" + cdTipoParcela + "]";
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCdEmpresa() {
		return cdEmpresa;
	}
	public void setCdEmpresa(Long cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}
	public Long getCdArea() {
		return cdArea;
	}
	public void setCdArea(Long cdArea) {
		this.cdArea = cdArea;
	}
	public Integer getCdParcelaInicio() {
		return cdParcelaInicio;
	}
	public void setCdParcelaInicio(Integer cdParcelaInicio) {
		this.cdParcelaInicio = cdParcelaInicio;
	}
	public Integer getNrParcelas() {
		return nrParcelas;
	}
	public void setNrParcelas(Integer nrParcelas) {
		this.nrParcelas = nrParcelas;
	}
	public Integer getNrSubParcelasPorParcelas() {
		return nrSubParcelasPorParcelas;
	}
	public void setNrSubParcelasPorParcelas(Integer nrSubParcelasPorParcelas) {
		this.nrSubParcelasPorParcelas = nrSubParcelasPorParcelas;
	}
	public Long getCdTipoParcela() {
		return cdTipoParcela;
	}
	public void setCdTipoParcela(Long cdTipoParcela) {
		this.cdTipoParcela = cdTipoParcela;
	}
	
	

}
