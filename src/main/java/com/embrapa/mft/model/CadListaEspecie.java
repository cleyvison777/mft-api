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
@Table(name = "d05_lista_especie")
public class CadListaEspecie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d05_cdlistaesp")
	private long cdListaEsp;
	
	@ManyToOne
	@JoinColumn(name ="d05_cdempresa")
	private CadEmpresa cdEmpresa; 
	
	@Column(name = "d05_nmlistaesp")
	private String nmListaEsp;
	
	
	public long getCdListaEsp() {
		return cdListaEsp;
	}
	public void setCdListaEsp(long cdListaEsp) {
		this.cdListaEsp = cdListaEsp;
	}
	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}
	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}
	public String getNmListaEsp() {
		return nmListaEsp;
	}
	public void setNmListaEsp(String nmListaEsp) {
		this.nmListaEsp = nmListaEsp;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdListaEsp ^ (cdListaEsp >>> 32));
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
		CadListaEspecie other = (CadListaEspecie) obj;
		if (cdListaEsp != other.cdListaEsp)
			return false;
		return true;
	} 
	
	

}
