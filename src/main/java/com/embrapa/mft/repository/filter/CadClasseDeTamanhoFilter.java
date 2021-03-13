package com.embrapa.mft.repository.filter;

import com.embrapa.mft.model.CadAmf;
import com.embrapa.mft.model.CadEmpresa;

public class CadClasseDeTamanhoFilter {
	
	private CadAmf cdArea;
	private CadEmpresa cdEmpresa;

	public CadAmf getCdArea() {
		return cdArea;
	}

	public void setCdArea(CadAmf cdArea) {
		this.cdArea = cdArea;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}
	

}
