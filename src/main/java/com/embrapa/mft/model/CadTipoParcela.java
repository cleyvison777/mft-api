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
@Table(name = "d22_tipo_parcela")
public class CadTipoParcela {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "d22_cdtipoparcela")
private long cdTipoParcela;

@ManyToOne
@JoinColumn(name = "d22_cdempresa")
private CadEmpresa cdEmpresa;


@Column(name = "d22_nmtipoparcela")
private String nmTipoParcela;

@Column(name = "d22_lgestudocrescimento")
private Boolean lgEstudoCrescimento;

public long getCdTipoParcela() {
	return cdTipoParcela;
}

public void setCdTipoParcela(long cdTipoParcela) {
	this.cdTipoParcela = cdTipoParcela;
}

public CadEmpresa getCdEmpresa() {
	return cdEmpresa;
}

public void setCdEmpresa(CadEmpresa cdEmpresa) {
	this.cdEmpresa = cdEmpresa;
}

public String getNmTipoParcela() {
	return nmTipoParcela;
}

public void setNmTipoParcela(String nmTipoParcela) {
	this.nmTipoParcela = nmTipoParcela;
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
	result = prime * result + (int) (cdTipoParcela ^ (cdTipoParcela >>> 32));
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
	CadTipoParcela other = (CadTipoParcela) obj;
	if (cdTipoParcela != other.cdTipoParcela)
		return false;
	return true;
}



}
