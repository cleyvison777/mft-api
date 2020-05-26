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
@Table(name="d22_tipo_parcela")
public class TipoParcelaMft {
    
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "d22_cdtipoparcela")
	private long cdTipoparcela;
	
	@ManyToOne
	@JoinColumn(name ="d22_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@Column(name= "d22_nmtipoparcela")
	private String nmTipoparcela;
	
	@Column(name= "d22_lgestudocrescimento")
	private Boolean lgEstudoCrescimento;

	public long getCdTipoparcela() {
		return cdTipoparcela;
	}

	public void setCdTipoparcela(long cdTipoparcela) {
		this.cdTipoparcela = cdTipoparcela;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public String getNmTipoparcela() {
		return nmTipoparcela;
	}

	public void setNmTipoparcela(String nmTipoparcela) {
		this.nmTipoparcela = nmTipoparcela;
	}

	public Boolean getLgEstudoCrescimento() {
		return lgEstudoCrescimento;
	}

	public void setLgEstudoCrescimento(Boolean lgEstudoCrescimento) {
		this.lgEstudoCrescimento = lgEstudoCrescimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdTipoparcela ^ (cdTipoparcela >>> 32));
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
		TipoParcelaMft other = (TipoParcelaMft) obj;
		if (cdTipoparcela != other.cdTipoparcela)
			return false;
		return true;
	}
	
	
	
	
}


