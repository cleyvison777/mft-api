package com.embrapa.mft.repository.filter;

public class CadMedicaoFilter {
	
	private String txObservacao;
	private Long cdEmpresa;
	
	public String getTxObservacao() {
		return txObservacao;
	}
	
	public void setTxObservacao(String txObservacao) {
		this.txObservacao = txObservacao;
	}

	public Long getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(Long cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}
	
	

}
