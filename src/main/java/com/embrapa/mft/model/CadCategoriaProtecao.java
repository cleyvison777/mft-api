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
@Table(name = "d09_categoria_protecao")
public class CadCategoriaProtecao {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "d09_cdcategoriaprotecao")
	private Long cdCategoriaProtecao;
	
	
	@ManyToOne
	@JoinColumn(name = "d09_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@Column(name = "d09_nmcategoriaprotecao")
	private String nmCategoriaProtecao;
	public Long getCdCategoriaProtecao() {
		return cdCategoriaProtecao;
	}
	public void setCdCategoriaProtecao(Long cdCategoriaProtecao) {
		this.cdCategoriaProtecao = cdCategoriaProtecao;
	}
	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}
	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}
	public String getNmCategoriaProtecao() {
		return nmCategoriaProtecao;
	}
	public void setNmCategoriaProtecao(String nmCategoriaProtecao) {
		this.nmCategoriaProtecao = nmCategoriaProtecao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdCategoriaProtecao == null) ? 0 : cdCategoriaProtecao.hashCode());
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
		CadCategoriaProtecao other = (CadCategoriaProtecao) obj;
		if (cdCategoriaProtecao == null) {
			if (other.cdCategoriaProtecao != null)
				return false;
		} else if (!cdCategoriaProtecao.equals(other.cdCategoriaProtecao))
			return false;
		return true;
	}
	
	
}
