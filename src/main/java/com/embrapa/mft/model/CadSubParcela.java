package com.embrapa.mft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="d29_subparcela")
public class CadSubParcela {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(name = "d29_cdsubparcela")
	private Long cdSubParcela;
	
	@ManyToOne
	@JoinColumn(name= "d29_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@ManyToOne
	@JoinColumn(name= "d29_cdparcela")
	private CadParcela cdParcela;
		
	@ManyToOne
	@JoinColumn(name= "d29_cdarea")
	private CadAmf cdArea;

	public Long getCdSubParcela() {
		return cdSubParcela;
	}

	public void setCdSubParcela(Long cdSubParcela) {
		this.cdSubParcela = cdSubParcela;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public CadParcela getCdParcela() {
		return cdParcela;
	}

	public void setCdParcela(CadParcela cdParcela) {
		this.cdParcela = cdParcela;
	}

	public CadAmf getCdArea() {
		return cdArea;
	}

	public void setCdArea(CadAmf cdArea) {
		this.cdArea = cdArea;
	}
	
	
	
	
	
}
