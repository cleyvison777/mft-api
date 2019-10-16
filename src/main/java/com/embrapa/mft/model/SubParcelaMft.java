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
@Table(name = "d29_subparcela")
public class SubParcelaMft {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "d29_cdsubparcela")
	private long cdSubparcela;
	
	@ManyToOne
	@JoinColumn(name ="d29_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@ManyToOne
	@JoinColumn(name ="d29_cdarea")
	private CadAmf cdArea; 
	@ManyToOne
	@JoinColumn(name ="d29_cdparcela")
	private ParcelaMft cdParcela;
	
	public long getCdSubparcela() {
		return cdSubparcela;
	}
	public void setCdSubparcela(long cdSubparcela) {
		this.cdSubparcela = cdSubparcela;
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
	public ParcelaMft getCdParcela() {
		return cdParcela;
	}
	public void setCdParcela(ParcelaMft cdParcela) {
		this.cdParcela = cdParcela;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdSubparcela ^ (cdSubparcela >>> 32));
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
		SubParcelaMft other = (SubParcelaMft) obj;
		if (cdSubparcela != other.cdSubparcela)
			return false;
		return true;
	} 
	 	
	
	
}
