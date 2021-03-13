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
@Table(name="d08_equacao")
public class CadEquacao {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "d08_cdequacao")
	private Long cdEquacao;
	
	@ManyToOne
	@JoinColumn(name = "d08_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@Column(name = "d08_nmequacao")
	private String nmEquacao; 
	
	@Column(name ="d08_equacao")
	private String Equacao; 
	
	@Column(name ="d08_txobservacaoequacao")
	private String txObservacaoEquacao; 
	
	@Column (name = "d08_imequacao")
	private String  imgEquacao;
	
	public Long getCdEquacao() {
		return cdEquacao;
	}
	public void setCdEquacao(Long cdEquacao) {
		this.cdEquacao = cdEquacao;
	}
	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}
	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}
	public String getNmEquacao() {
		return nmEquacao;
	}
	public void setNmEquacao(String nmEquacao) {
		this.nmEquacao = nmEquacao;
	}
	public String getEquacao() {
		return Equacao;
	}
	public void setEquacao(String equacao) {
		Equacao = equacao;
	}
	public String getTxObservacaoEquacao() {
		return txObservacaoEquacao;
	}
	public void setTxObservacaoEquacao(String txObservacaoEquacao) {
		this.txObservacaoEquacao = txObservacaoEquacao;
	}
	
	public String getImgEquacao() {
		return imgEquacao;
	}
	
	public void setImgEquacao(String imgEquacao) {
		this.imgEquacao = imgEquacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdEquacao == null) ? 0 : cdEquacao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadEquacao other = (CadEquacao) obj;
		if (cdEquacao == null) {
			if (other.cdEquacao != null)
				return false;
		} else if (!cdEquacao.equals(other.cdEquacao))
			return false;
		return true;
	}
	
	
	
	
	



 }


