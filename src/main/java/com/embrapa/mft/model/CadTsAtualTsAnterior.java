package com.embrapa.mft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "r35_ts_atual_ts_anterior")
public class CadTsAtualTsAnterior {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r35_cdtratamentoanteriorPK")
	private long cdTratamentoAnteriorPk;
	
	@ManyToOne
	@JoinColumn(name = "r35_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@ManyToOne
	@JoinColumn(name = "r35_cdtratamentoanterior", referencedColumnName = "d36_cdtratamento")
	private CadTratamentoSilvicultural cdTratamentoAnterior;
	
	@ManyToOne
	@JoinColumn(name = "r35_cdtratamentoatual", referencedColumnName = "d36_cdtratamento")
	private CadTratamentoSilvicultural cdTratamentotual;
	


	public CadTratamentoSilvicultural getCdTratamentotual() {
		return cdTratamentotual;
	}

	public void setCdTratamentotual(CadTratamentoSilvicultural cdTratamentotual) {
		this.cdTratamentotual = cdTratamentotual;
	}
	

	

	public CadTratamentoSilvicultural getCdTratamentoAnterior() {
		return cdTratamentoAnterior;
	}

	public void setCdTratamentoAnterior(CadTratamentoSilvicultural cdTratamentoAnterior) {
		this.cdTratamentoAnterior = cdTratamentoAnterior;
	}


	public long getCdTratamentoAnteriorPk() {
		return cdTratamentoAnteriorPk;
	}

	public void setCdTratamentoAnteriorPk(long cdTratamentoAnteriorPk) {
		this.cdTratamentoAnteriorPk = cdTratamentoAnteriorPk;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdTratamentoAnteriorPk ^ (cdTratamentoAnteriorPk >>> 32));
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
		CadTsAtualTsAnterior other = (CadTsAtualTsAnterior) obj;
		if (cdTratamentoAnteriorPk != other.cdTratamentoAnteriorPk)
			return false;
		return true;
	}



	

}
