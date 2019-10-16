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
@Table(name = "d20_area")
public class CadAmf {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d20_cdarea")
	private long cdarea;
	
	@Column (name = "d20_nmarea")
	private String nmArea;
	
	@Column (name = "d20_nmestado")
	private String nmEstado;
	
	@Column (name = "d20_nmmunicipio")
	private String nmMunicipio;
	
	@Column (name = "d20_latitude1grau")
	private double latitude1Grau; 
	
	@Column (name = "d20_latitude1minuto")
	private double latitude1Minuto; 
	
	@Column (name = "d20_latitude1orientacao")
	private char latitude1Orientacao; 
	
	@Column (name = "d20_latitude2grau")
	private double latitude2Grau; 
	
	@Column (name = "d20_latitude2minuto")
	private double latitude2Minuto; 
	
	@Column (name = "d20_latitude2orientacao")
	private char latitude2Orientacao;
	
	@Column (name = "d20_longitude1grau")
	private double longitude1Grau; 
	
	@Column (name = "d20_longitude1minuto")
	private double longitude1Minuto; 
	
	@Column (name = "d20_longitude1orientacao")
	private char longitude1Orientacao; 
	
	@Column (name = "d20_longitude2grau") 
	private double longitude2Grau; 
	
	@Column (name = "d20_longitude2minuto")
	private double longitude2Minuto; 
	
	@Column (name = "d20_longitude2orientacao")
	private char longitude2Orientacao; 
	
	@Column (name = "d20_precipmediaanualmm")
	private double precipMediaAnualmm; 
	
	@Column (name = "d20_precipmediamensalchuvamm")
	private double precipMediaMensalChuvamm; 
	
	@Column (name = "d20_precipmediamensalsecamm")
	private double precipMediaMensalSecamm;
	
	@Column (name = "d20_mesesseca")
	private String mesesSeca; 
	
	@Column (name = "d20_meseschuva")
	private String mesesChuva; 
	
	@Column (name = "d20_tipologiaflorestal")
	private String tipoLogiaFlorestal;
	
	@Column (name = "d20_tiposolo")
	private String tipoSolo;
	
	@Column (name = "d20_relevo")
	private String Relevo; 
	
	@Column (name = "d20_nmresponsavel")
	private String mnResponsavel; 
	
	@Column (name = "d20_enderecoresponsavel")
	private String enderecoResponsavel; 
	
	@Column (name = "d20_nrtelefoneresponsavel")
	private String nrTelefoneResponsavel;
	
	@Column (name = "d20_emailresponsavel")
	private String emailResponsavel; 

	@Column (name = "d20_txhistoricoarea")
	private String txHistoricoArea; 
	
	@Column (name = "d20_txobservacaoarea")
	private String txObservacaoArea; 
	
	@Column (name = "d20_cdlistaesp")
	private double cdListaEsp; 
	
	@Column (name = "d20_lgmudacontada")
	private double lgMudaContada; 
	
	@Column (name = "d20_lgpalmeiracontada")
	private double lgPalmeiraContada; 
	
	@Column (name = "d20_cdequacaoareabasalpadrao")
	private double cdEquacaoAreaBasalPadrao;
	
	@Column (name = "d20_cdequacaovolumeinvtemp") 
	private double cdEquacaovolumeinvtemp;
    
	@ManyToOne
	@JoinColumn(name ="d20_cdempresa")
	private CadEmpresa cdEmpresa;

	public long getCdarea() {
		return cdarea;
	}

	public void setCdarea(long cdarea) {
		this.cdarea = cdarea;
	}

	public String getNmArea() {
		return nmArea;
	}

	public void setNmArea(String nmArea) {
		this.nmArea = nmArea;
	}

	public String getNmEstado() {
		return nmEstado;
	}

	public void setNmEstado(String nmEstado) {
		this.nmEstado = nmEstado;
	}

	public String getNmMunicipio() {
		return nmMunicipio;
	}

	public void setNmMunicipio(String nmMunicipio) {
		this.nmMunicipio = nmMunicipio;
	}

	public double getLatitude1Grau() {
		return latitude1Grau;
	}

	public void setLatitude1Grau(double latitude1Grau) {
		this.latitude1Grau = latitude1Grau;
	}

	public double getLatitude1Minuto() {
		return latitude1Minuto;
	}

	public void setLatitude1Minuto(double latitude1Minuto) {
		this.latitude1Minuto = latitude1Minuto;
	}

	public char getLatitude1Orientacao() {
		return latitude1Orientacao;
	}

	public void setLatitude1Orientacao(char latitude1Orientacao) {
		this.latitude1Orientacao = latitude1Orientacao;
	}

	public double getLatitude2Grau() {
		return latitude2Grau;
	}

	public void setLatitude2Grau(double latitude2Grau) {
		this.latitude2Grau = latitude2Grau;
	}

	public double getLatitude2Minuto() {
		return latitude2Minuto;
	}

	public void setLatitude2Minuto(double latitude2Minuto) {
		this.latitude2Minuto = latitude2Minuto;
	}

	public char getLatitude2Orientacao() {
		return latitude2Orientacao;
	}

	public void setLatitude2Orientacao(char latitude2Orientacao) {
		this.latitude2Orientacao = latitude2Orientacao;
	}

	public double getLongitude1Grau() {
		return longitude1Grau;
	}

	public void setLongitude1Grau(double longitude1Grau) {
		this.longitude1Grau = longitude1Grau;
	}

	public double getLongitude1Minuto() {
		return longitude1Minuto;
	}

	public void setLongitude1Minuto(double longitude1Minuto) {
		this.longitude1Minuto = longitude1Minuto;
	}

	public char getLongitude1Orientacao() {
		return longitude1Orientacao;
	}

	public void setLongitude1Orientacao(char longitude1Orientacao) {
		this.longitude1Orientacao = longitude1Orientacao;
	}

	public double getLongitude2Grau() {
		return longitude2Grau;
	}

	public void setLongitude2Grau(double longitude2Grau) {
		this.longitude2Grau = longitude2Grau;
	}

	public double getLongitude2Minuto() {
		return longitude2Minuto;
	}

	public void setLongitude2Minuto(double longitude2Minuto) {
		this.longitude2Minuto = longitude2Minuto;
	}

	public char getLongitude2Orientacao() {
		return longitude2Orientacao;
	}

	public void setLongitude2Orientacao(char longitude2Orientacao) {
		this.longitude2Orientacao = longitude2Orientacao;
	}

	public double getPrecipMediaAnualmm() {
		return precipMediaAnualmm;
	}

	public void setPrecipMediaAnualmm(double precipMediaAnualmm) {
		this.precipMediaAnualmm = precipMediaAnualmm;
	}

	public double getPrecipMediaMensalChuvamm() {
		return precipMediaMensalChuvamm;
	}

	public void setPrecipMediaMensalChuvamm(double precipMediaMensalChuvamm) {
		this.precipMediaMensalChuvamm = precipMediaMensalChuvamm;
	}

	public double getPrecipMediaMensalSecamm() {
		return precipMediaMensalSecamm;
	}

	public void setPrecipMediaMensalSecamm(double precipMediaMensalSecamm) {
		this.precipMediaMensalSecamm = precipMediaMensalSecamm;
	}

	public String getMesesSeca() {
		return mesesSeca;
	}

	public void setMesesSeca(String mesesSeca) {
		this.mesesSeca = mesesSeca;
	}

	public String getMesesChuva() {
		return mesesChuva;
	}

	public void setMesesChuva(String mesesChuva) {
		this.mesesChuva = mesesChuva;
	}

	public String getTipoLogiaFlorestal() {
		return tipoLogiaFlorestal;
	}

	public void setTipoLogiaFlorestal(String tipoLogiaFlorestal) {
		this.tipoLogiaFlorestal = tipoLogiaFlorestal;
	}

	public String getTipoSolo() {
		return tipoSolo;
	}

	public void setTipoSolo(String tipoSolo) {
		this.tipoSolo = tipoSolo;
	}

	public String getRelevo() {
		return Relevo;
	}

	public void setRelevo(String relevo) {
		Relevo = relevo;
	}

	public String getNmResponsavel() {
		return mnResponsavel;
	}

	public void setNmResponsavel(String nmResonsavel) {
		this.mnResponsavel = nmResonsavel;
	}

	public String getEnderecoResponsavel() {
		return enderecoResponsavel;
	}

	public void setEnderecoResponsavel(String enderecoResponsavel) {
		this.enderecoResponsavel = enderecoResponsavel;
	}

	public String getNrTelefoneResponsavel() {
		return nrTelefoneResponsavel;
	}

	public void setNrTelefoneResponsavel(String nrTelefoneResponsavel) {
		this.nrTelefoneResponsavel = nrTelefoneResponsavel;
	}

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
	}

	public String getTxHistoricoArea() {
		return txHistoricoArea;
	}

	public void setTxHistoricoArea(String txHistoricoArea) {
		this.txHistoricoArea = txHistoricoArea;
	}

	public String getTxObservacaoArea() {
		return txObservacaoArea;
	}

	public void setTxObservacaoArea(String txObservacaoArea) {
		this.txObservacaoArea = txObservacaoArea;
	}

	public double getCdListaEsp() {
		return cdListaEsp;
	}

	public void setCdListaEsp(double cdListaEsp) {
		this.cdListaEsp = cdListaEsp;
	}

	public double getLgMudaContada() {
		return lgMudaContada;
	}

	public void setLgMudaContada(double lgMudaContada) {
		this.lgMudaContada = lgMudaContada;
	}

	public double getLgPalmeiraContada() {
		return lgPalmeiraContada;
	}

	public void setLgPalmeiraContada(double lgPalmeiraContada) {
		this.lgPalmeiraContada = lgPalmeiraContada;
	}

	public double getCdEquacaoAreaBasalPadrao() {
		return cdEquacaoAreaBasalPadrao;
	}

	public void setCdEquacaoAreaBasalPadrao(double cdEquacaoAreaBasalPadrao) {
		this.cdEquacaoAreaBasalPadrao = cdEquacaoAreaBasalPadrao;
	}

	public double getCdEquacaovolumeinvtemp() {
		return cdEquacaovolumeinvtemp;
	}

	public void setCdEquacaoVolumeInvTemp(double cdEquacaoVolumeInvTemp) {
		this.cdEquacaovolumeinvtemp = cdEquacaoVolumeInvTemp;
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
		result = prime * result + (int) (cdarea ^ (cdarea >>> 32));
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
		CadAmf other = (CadAmf) obj;
		if (cdarea != other.cdarea)
			return false;
		return true;
	}

	
	
	
	
}
