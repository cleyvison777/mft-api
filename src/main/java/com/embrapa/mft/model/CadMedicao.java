package com.embrapa.mft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "d18_medicao")
public class CadMedicao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d18_cdmedicao")
	private Long cdMedicao;

	@ManyToOne
	@JoinColumn(name= "d18_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@ManyToOne
	@JoinColumn(name= "d18_cdarea")
	private CadAmf cdArea; 
	
	@Column(name = "d18_dtiniciomedicao")
	private Date dtInicioMedica;
	
	@Column(name = "d18_txobservacao")
	private String txObservacao;
	
	public Long getCdMedicao() {
		return cdMedicao;
	}
	
	public void setCdMedicao(Long cdMedicao) {
		this.cdMedicao = cdMedicao;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public CadAmf getCdArea() {
		return cdArea;
	}

	public void setCdArea(CadAmf cdArea) {
		this.cdArea = cdArea;
	}

	public Date getDtInicioMedica() {
		return dtInicioMedica;
	}

	public void setDtInicioMedica(Date dtInicioMedica) {
		this.dtInicioMedica = dtInicioMedica;
	}

	public String getTxObservacao() {
		return txObservacao;
	}

	public void setTxObservacao(String txObservacao) {
		this.txObservacao = txObservacao;
	}
	
	
}
