package com.embrapa.mft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="d13_empresa")
public class CadEmpresa {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d13_cdempresa")
	private Long cdEmpresa;

	@Column(name="d13_nmempresa")
	private String nmEmpresa;
	
	@Column(name="d13_nmabreviado")
	private String nmAbreviado;
	
	@Column(name="d13_nrtelefone")
	private String nrTelefone;

	@Column(name="d13_enderecocompleto")
	private String enderecoCompleto;
	
	@Column(name="d13_txpessoacontato")
	private String txPessoacontato;

	@Column(name="d13_cnpjempresa")
	private String cnpjEmpresa;
	
	@Column(name="d13_diretorioarquivos")
	private String diretorioArquivos;

	public Long getCdEmpresa() {
		return cdEmpresa;
	}
	public void setCdEmpresa(Long cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}
	public String getNmEmpresa() {
		return nmEmpresa;
	}
	public void setNmEmpresa(String nmEmpresa) {
		this.nmEmpresa = nmEmpresa;
	}
	public String getNmAbreviado() {
		return nmAbreviado;
	}
	public void setNmAbreviado(String nmAbreviado) {
		this.nmAbreviado = nmAbreviado;
	}
	public String getNrTelefone() {
		return nrTelefone;
	}
	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}
	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}
	public void setEnderecoCompleto(String EnderecoCompleto) {
		this.enderecoCompleto = EnderecoCompleto;
	}
	public String getTxPessoacontato() {
		return txPessoacontato;
	}
	public void setTxPessoacontato(String txPessoacontato) {
		this.txPessoacontato = txPessoacontato;
	}
	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}
	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	public String getDiretorioArquivos() {
		return diretorioArquivos;
	}
	public void setDiretorioArquivos(String diretorioArquivos) {
		this.diretorioArquivos = diretorioArquivos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdEmpresa ^ (cdEmpresa >>> 32));
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
		CadEmpresa other = (CadEmpresa) obj;
		if (cdEmpresa != other.cdEmpresa)
			return false;
		return true;
	}
	
	
	
	
}