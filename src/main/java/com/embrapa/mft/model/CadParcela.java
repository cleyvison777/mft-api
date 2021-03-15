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
@Table(name = "d21_parcela")
public class CadParcela {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "d21_cdparcela")
	private Long cdParcela;
	
	@ManyToOne
	@JoinColumn(name= "d21_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@ManyToOne
	@JoinColumn(name= "d21_cdarea")
	private CadAmf cdArea;
	
	@ManyToOne
	@JoinColumn(name= "d21_cdtipoparcela")
	private CadTipoParcela cdTipoParcela;
	
	@Column(name = "d21_txobservacaoparcela")
	private String txObservacoesParcela;
	
	@Column(name = "d21_latitudeponto1grau")
	private Integer latitudePonto1Grau;
	
	@Column(name = "d21_latitudeponto1minuto")
	private Integer latitudePonto1Minuto;
	
	@Column(name = "d21_latitudeponto1orientacao")
	private String latitudePonto1Orientacao;
	
	@Column(name = "d21_longitudeponto1grau")
	private Integer longitudePonto1Grau;
	
	@Column(name = "d21_longitudeponto1minuto")
	private Integer longitudePonto1Minuto;
	
	@Column(name = "d21_longitudeponto1orientacao")
	private String longitudePonto1Orientacao;
	
	@Column(name = "d21_latitudeponto2grau")
	private Integer latitudePonto2Grau;
	
	@Column(name = "d21_latitudeponto2minuto")
	private Integer latitudePonto2Minuto;
	
	@Column(name = "d21_latitudeponto2orientacao")
	private String latitudePonto2Orientacao;
	
	@Column(name = "d21_longitudeponto2grau")
	private Integer longitudePonto2Grau;
	
	@Column(name = "d21_longitudeponto2minuto")
	private Integer longitudePonto2Minuto;
	
	@Column(name = "d21_longitudeponto2orientacao")
	private String longitudePonto2Orientacao;
	
	@Column(name = "d21_latitudeponto3grau")
	private Integer latitudePonto3Grau;
	
	@Column(name = "d21_latitudeponto3minuto")
	private Integer latitudePonto3Minuto;
	
	@Column(name = "d21_latitudeponto3orientacao")
	private String latitudePonto3Orientacao;
	
	@Column(name = "d21_longitudeponto3grau")
	private Integer longitudePonto3Grau;
	
	@Column(name = "d21_longitudeponto3minuto")
	private Integer longitudePonto3Minuto;
	
	@Column(name = "d21_longitudeponto3orientacao")
	private String longitudePonto3Orientacao;
	
	@Column(name = "d21_latitudeponto4grau")
	private Integer latitudePonto4Grau;
	
	@Column(name = "d21_latitudeponto4minuto")
	private Integer latitudePonto4Minuto;
	
	@Column(name = "d21_latitudeponto4orientacao")
	private String latitudePonto4Orientacao;
	
	@Column(name = "d21_longitudeponto4grau")
	private Integer longitudePonto4Grau;
	
	@Column(name = "d21_longitudeponto4minuto")
	private Integer longitudePonto4Minuto;
	
	@Column(name = "d21_longitudeponto4orientacao")
	private String longitudePonto4Orientacao;
	
	@Column(name = "d21_lgtestemunha")
	private boolean lgTestemunha;

	public Long getCdParcela() {
		return cdParcela;
	}

	public void setCdParcela(Long cdParcela) {
		this.cdParcela = cdParcela;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public CadAmf getCdArea() {
		return cdArea;
	}

	public void setCdArea(CadAmf cdArea) {
		this.cdArea = cdArea;
	}

	public CadTipoParcela getCdTipoParcela() {
		return cdTipoParcela;
	}

	public void setCdTipoParcela(CadTipoParcela cdTipoParcela) {
		this.cdTipoParcela = cdTipoParcela;
	}

	public String getTxObservacoesParcela() {
		return txObservacoesParcela;
	}

	public void setTxObservacoesParcela(String txObservacoesParcela) {
		this.txObservacoesParcela = txObservacoesParcela;
	}

	public Integer getLatitudePonto1Grau() {
		return latitudePonto1Grau;
	}

	public void setLatitudePonto1Grau(Integer latitudePonto1Grau) {
		this.latitudePonto1Grau = latitudePonto1Grau;
	}

	public Integer getLatitudePonto1Minuto() {
		return latitudePonto1Minuto;
	}

	public void setLatitudePonto1Minuto(Integer latitudePonto1Minuto) {
		this.latitudePonto1Minuto = latitudePonto1Minuto;
	}

	public String getLatitudePonto1Orientacao() {
		return latitudePonto1Orientacao;
	}

	public void setLatitudePonto1Orientacao(String latitudePonto1Orientacao) {
		this.latitudePonto1Orientacao = latitudePonto1Orientacao;
	}

	public Integer getLongitudePonto1Grau() {
		return longitudePonto1Grau;
	}

	public void setLongitudePonto1Grau(Integer longitudePonto1Grau) {
		this.longitudePonto1Grau = longitudePonto1Grau;
	}

	public Integer getLongitudePonto1Minuto() {
		return longitudePonto1Minuto;
	}

	public void setLongitudePonto1Minuto(Integer longitudePonto1Minuto) {
		this.longitudePonto1Minuto = longitudePonto1Minuto;
	}

	public String getLongitudePonto1Orientacao() {
		return longitudePonto1Orientacao;
	}

	public void setLongitudePonto1Orientacao(String longitudePonto1Orientacao) {
		this.longitudePonto1Orientacao = longitudePonto1Orientacao;
	}

	public Integer getLatitudePonto2Grau() {
		return latitudePonto2Grau;
	}

	public void setLatitudePonto2Grau(Integer latitudePonto2Grau) {
		this.latitudePonto2Grau = latitudePonto2Grau;
	}

	public Integer getLatitudePonto2Minuto() {
		return latitudePonto2Minuto;
	}

	public void setLatitudePonto2Minuto(Integer latitudePonto2Minuto) {
		this.latitudePonto2Minuto = latitudePonto2Minuto;
	}

	public String getLatitudePonto2Orientacao() {
		return latitudePonto2Orientacao;
	}

	public void setLatitudePonto2Orientacao(String latitudePonto2Orientacao) {
		this.latitudePonto2Orientacao = latitudePonto2Orientacao;
	}

	public Integer getLongitudePonto2Grau() {
		return longitudePonto2Grau;
	}

	public void setLongitudePonto2Grau(Integer longitudePonto2Grau) {
		this.longitudePonto2Grau = longitudePonto2Grau;
	}

	public Integer getLongitudePonto2Minuto() {
		return longitudePonto2Minuto;
	}

	public void setLongitudePonto2Minuto(Integer longitudePonto2Minuto) {
		this.longitudePonto2Minuto = longitudePonto2Minuto;
	}

	public String getLongitudePonto2Orientacao() {
		return longitudePonto2Orientacao;
	}

	public void setLongitudePonto2Orientacao(String longitudePonto2Orientacao) {
		this.longitudePonto2Orientacao = longitudePonto2Orientacao;
	}

	public Integer getLatitudePonto3Grau() {
		return latitudePonto3Grau;
	}

	public void setLatitudePonto3Grau(Integer latitudePonto3Grau) {
		this.latitudePonto3Grau = latitudePonto3Grau;
	}

	public Integer getLatitudePonto3Minuto() {
		return latitudePonto3Minuto;
	}

	public void setLatitudePonto3Minuto(Integer latitudePonto3Minuto) {
		this.latitudePonto3Minuto = latitudePonto3Minuto;
	}

	public String getLatitudePonto3Orientacao() {
		return latitudePonto3Orientacao;
	}

	public void setLatitudePonto3Orientacao(String latitudePonto3Orientacao) {
		this.latitudePonto3Orientacao = latitudePonto3Orientacao;
	}

	public Integer getLongitudePonto3Grau() {
		return longitudePonto3Grau;
	}

	public void setLongitudePonto3Grau(Integer longitudePonto3Grau) {
		this.longitudePonto3Grau = longitudePonto3Grau;
	}

	public Integer getLongitudePonto3Minuto() {
		return longitudePonto3Minuto;
	}

	public void setLongitudePonto3Minuto(Integer longitudePonto3Minuto) {
		this.longitudePonto3Minuto = longitudePonto3Minuto;
	}

	public String getLongitudePonto3Orientacao() {
		return longitudePonto3Orientacao;
	}

	public void setLongitudePonto3Orientacao(String longitudePonto3Orientacao) {
		this.longitudePonto3Orientacao = longitudePonto3Orientacao;
	}

	public Integer getLatitudePonto4Grau() {
		return latitudePonto4Grau;
	}

	public void setLatitudePonto4Grau(Integer latitudePonto4Grau) {
		this.latitudePonto4Grau = latitudePonto4Grau;
	}

	public Integer getLatitudePonto4Minuto() {
		return latitudePonto4Minuto;
	}

	public void setLatitudePonto4Minuto(Integer latitudePonto4Minuto) {
		this.latitudePonto4Minuto = latitudePonto4Minuto;
	}

	public String getLatitudePonto4Orientacao() {
		return latitudePonto4Orientacao;
	}

	public void setLatitudePonto4Orientacao(String latitudePonto4Orientacao) {
		this.latitudePonto4Orientacao = latitudePonto4Orientacao;
	}

	public Integer getLongitudePonto4Grau() {
		return longitudePonto4Grau;
	}

	public void setLongitudePonto4Grau(Integer longitudePonto4Grau) {
		this.longitudePonto4Grau = longitudePonto4Grau;
	}

	public Integer getLongitudePonto4Minuto() {
		return longitudePonto4Minuto;
	}

	public void setLongitudePonto4Minuto(Integer longitudePonto4Minuto) {
		this.longitudePonto4Minuto = longitudePonto4Minuto;
	}

	public String getLongitudePonto4Orientacao() {
		return longitudePonto4Orientacao;
	}

	public void setLongitudePonto4Orientacao(String longitudePonto4Orientacao) {
		this.longitudePonto4Orientacao = longitudePonto4Orientacao;
	}

	public boolean isLgTestemunha() {
		return lgTestemunha;
	}

	public void setLgTestemunha(boolean lgTestemunha) {
		this.lgTestemunha = lgTestemunha;
	}
	
	
	

	
}
