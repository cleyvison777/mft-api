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
@Table(name="d30_classe_floresta")
public class ICClasseDeFloresta {

	@Id
	@Column(name="d30_cdclassefloresta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cdClassefloresta;
	
	@ManyToOne
	@JoinColumn(name= "d30_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@Column(name="d30_nmclassefloresta")
	private String nmClassefloresta;
	
	@Column(name = "d30_imfigura")
	private String enderecoImagem;

	public Long getCdClassefloresta() {
		return cdClassefloresta;
	}

	public void setCdClassefloresta(Long cdClassefloresta) {
		this.cdClassefloresta = cdClassefloresta;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public String getNmClassefloresta() {
		return nmClassefloresta;
	}

	public void setNmClassefloresta(String nmClassefloresta) {
		this.nmClassefloresta = nmClassefloresta;
	}

	public String getEnderecoImagem() {
		return enderecoImagem;
	}

	public void setEnderecoImagem(String enderecoImagem) {
		this.enderecoImagem = enderecoImagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdClassefloresta == null) ? 0 : cdClassefloresta.hashCode());
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
		ICClasseDeFloresta other = (ICClasseDeFloresta) obj;
		if (cdClassefloresta == null) {
			if (other.cdClassefloresta != null)
				return false;
		} else if (!cdClassefloresta.equals(other.cdClassefloresta))
			return false;
		return true;
	}
	
	
	
	
}
