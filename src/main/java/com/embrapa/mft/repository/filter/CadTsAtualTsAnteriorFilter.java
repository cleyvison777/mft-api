package com.embrapa.mft.repository.filter;

import com.embrapa.mft.model.CadEmpresa;
import com.embrapa.mft.model.CadTratamentoSilvicultural;

public class CadTsAtualTsAnteriorFilter {

	private CadTratamentoSilvicultural cdTratamentoAnterior;
	private long cdTratamentoAnteriorPk;
	private CadEmpresa cdEmpresa;
	private CadTratamentoSilvicultural cdTratamentotual;

	
	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}


	public long getCdTratamentoAnteriorPk() {
		return cdTratamentoAnteriorPk;
	}

	public void setCdTratamentoAnteriorPk(long cdTratamentoAnteriorPk) {
		this.cdTratamentoAnteriorPk = cdTratamentoAnteriorPk;
	}


	public CadTratamentoSilvicultural getCdTratamentoAnterior() {
		return cdTratamentoAnterior;
	}

	public void setCdTratamentoAnterior(CadTratamentoSilvicultural cdTratamentoAnterior) {
		this.cdTratamentoAnterior = cdTratamentoAnterior;
	}

	public CadTratamentoSilvicultural getCdTratamentotual() {
		return cdTratamentotual;
	}

	public void setCdTratamentotual(CadTratamentoSilvicultural cdTratamentotual) {
		this.cdTratamentotual = cdTratamentotual;
	}

	
}
