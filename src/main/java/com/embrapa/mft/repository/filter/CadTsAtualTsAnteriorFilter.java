package com.embrapa.mft.repository.filter;

import com.embrapa.mft.model.CadEmpresa;
import com.embrapa.mft.model.CadTratamentoSilvicultural;

public class CadTsAtualTsAnteriorFilter {

	private long cdTratamentAnterior;
	private CadEmpresa cdEmpresa;
	private CadTratamentoSilvicultural cdTratamentotual;

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public long getCdTratamentAnterior() {
		return cdTratamentAnterior;
	}

	public void setCdTratamentAnterior(long cdTratamentAnterior) {
		this.cdTratamentAnterior = cdTratamentAnterior;
	}

	public CadTratamentoSilvicultural getCdTratamentotual() {
		return cdTratamentotual;
	}

	public void setCdTratamentotual(CadTratamentoSilvicultural cdTratamentotual) {
		this.cdTratamentotual = cdTratamentotual;
	}

	
}
