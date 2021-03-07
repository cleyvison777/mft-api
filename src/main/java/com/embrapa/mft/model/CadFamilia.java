package com.embrapa.mft.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "d01_familia")
public class CadFamilia {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name= "d01_cdfamilia")
	private long cdFamilia;
	
	
	@Column (name = "d01_nmfamilia")
	private String nmFamilia;
	
	public long getCdFamilia() {
		return cdFamilia;
	}
	public void setCdFamilia(long cdFamilia) {
		this.cdFamilia = cdFamilia;
	}
	public String getNmFamilia() {
		return nmFamilia;
	}
	public void setNmFamilia(String nmFamilia) {
		this.nmFamilia = nmFamilia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdFamilia ^ (cdFamilia >>> 32));
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
		CadFamilia other = (CadFamilia) obj;
		if (cdFamilia != other.cdFamilia)
			return false;
		return true;
	}



}
