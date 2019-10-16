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
@Table(name="d06_grupo_ecologico")
public class CadGrupoEcologico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d06_cdgrupoecologico")
	private long cdGrupoEcologico;
	@ManyToOne
	@JoinColumn(name="d06_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@Column(name="d06_nmgrupoecologico")
	private String nmGrupoEcologico;

	public long getCdGrupoEcologico() {
		return cdGrupoEcologico;
	}

	public void setCdGrupoEcologico(long cdGrupoEcologico) {
		this.cdGrupoEcologico = cdGrupoEcologico;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public String getNmGrupoEcologico() {
		return nmGrupoEcologico;
	}

	public void setNmGrupoEcologico(String nmGrupoEcologico) {
		this.nmGrupoEcologico = nmGrupoEcologico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdGrupoEcologico ^ (cdGrupoEcologico >>> 32));
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
		CadGrupoEcologico other = (CadGrupoEcologico) obj;
		if (cdGrupoEcologico != other.cdGrupoEcologico)
			return false;
		return true;
	}
	
	
}
