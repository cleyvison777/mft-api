package com.embrapa.mft.repository.filter;

import com.embrapa.mft.model.CadEmpresa;

public class CadTsAtualTsAnteriorFilter {

	private long cdTratamentAnterior;
	private CadEmpresa cdEmpresa;
	

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
	
	
}
