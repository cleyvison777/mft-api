package com.embrapa.mft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d10_classe_tamanho_individuo")
public class CadClasseTamanhoIndividuo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "d10_cdclassetamanho")
	private long CdcClasseTamanho;
	
	@Column(name = "d10_nmclassetamanho")
	private String MmClasseTamanho;
	
	
	public long getCdcClasseTamanho() {
		return CdcClasseTamanho;
	}
	public void setCdcClasseTamanho(long cdcClasseTamanho) {
		CdcClasseTamanho = cdcClasseTamanho;
	}
	public String getMmClasseTamanho() {
		return MmClasseTamanho;
	}
	public void setMmClasseTamanho(String mmClasseTamanho) {
		MmClasseTamanho = mmClasseTamanho;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (CdcClasseTamanho ^ (CdcClasseTamanho >>> 32));
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
		CadClasseTamanhoIndividuo other = (CadClasseTamanhoIndividuo) obj;
		if (CdcClasseTamanho != other.CdcClasseTamanho)
			return false;
		return true;
	}	
	


}
