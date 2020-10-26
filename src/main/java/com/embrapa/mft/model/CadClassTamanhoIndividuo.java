package com.embrapa.mft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d10_classe_tamanho_individuo")
public class CadClassTamanhoIndividuo {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d10_cdclassetamanho")
	private long cdClasseTamanho;
	
	@Column(name = "d10_nmclassetamanho")
	private String nmClasseTamanho;

	public long getCdClasseTamanho() {
		return cdClasseTamanho;
	}

	public void setCdClasseTamanho(long cdClasseTamanho) {
		this.cdClasseTamanho = cdClasseTamanho;
	}

	public String getNmClasseTamanho() {
		return nmClasseTamanho;
	}

	public void setNmClasseTamanho(String nmClasseTamanho) {
		this.nmClasseTamanho = nmClasseTamanho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdClasseTamanho ^ (cdClasseTamanho >>> 32));
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
		CadClassTamanhoIndividuo other = (CadClassTamanhoIndividuo) obj;
		if (cdClasseTamanho != other.cdClasseTamanho)
			return false;
		return true;
	} 
	
	
}
