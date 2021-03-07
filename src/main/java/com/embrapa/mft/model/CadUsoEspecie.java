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
@Table(name = "d07_uso_especie")
public class CadUsoEspecie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d07_cduso")
	private long cdUso;
	
	@ManyToOne
	@JoinColumn(name = "d07_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@Column(name = "d07_nmuso")
	private String nmUso;
	
	@Column(name = "d07_lgmadeira")
	private String lgMadeira;
	
	
	public long getCdUso() {
		return cdUso;
	}

	public void setCdUso(long cdUso) {
		this.cdUso = cdUso;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public String getNmUso() {
		return nmUso;
	}

	public void setNmUso(String nmUso) {
		this.nmUso = nmUso;
	}

	public String getLgMadeira() {
		return lgMadeira;
	}

	public void setLgMadeira(String lgMadeira) {
		this.lgMadeira = lgMadeira;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdUso ^ (cdUso >>> 32));
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
		CadUsoEspecie other = (CadUsoEspecie) obj;
		if (cdUso != other.cdUso)
			return false;
		return true;
	}
	
	

}
