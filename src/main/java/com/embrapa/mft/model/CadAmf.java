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
	
	@ManyToOne
	@JoinColumn (name = "d20_cdlistaesp")
	private CadListaEspecie cdListaEsp; 
	
	@ManyToOne
	@JoinColumn(name ="d20_cdempresa", referencedColumnName = "d13_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@Column (name = "d20_cdequacaoareabasalpadrao")
	private long cdEquacaoAreaBasalPadrao;
	
	@Column (name = "d20_cdequacaovolumeinvtemp") 
	private long cdEquacaovolumeinvtemp;
    

	@Column (name = "d20_nmarea")
	private String nmArea;
	
	@Column (name = "d20_nmestado")
	private String nmEstado;
	
	@Column (name = "d20_nmmunicipio")
	private String nmMunicipio;
	
	@Column (name = "d20_latitude1grau")
	private Integer latitude1Grau; 
	
	@Column (name = "d20_latitude1minuto")
	private Integer latitude1Minuto; 
	
	@Column (name = "d20_latitude1orientacao")
	private String latitude1Orientacao; 
	
	@Column (name = "d20_latitude2grau")
	private Integer latitude2Grau; 
	
	@Column (name = "d20_latitude2minuto")
	private Integer latitude2Minuto; 
	
	@Column (name = "d20_latitude2orientacao")
	private String latitude2Orientacao;
	
	@Column (name = "d20_longitude1grau")
	private Integer longitude1Grau; 
	
	@Column (name = "d20_longitude1minuto")
	private Integer longitude1Minuto; 
	
	@Column (name = "d20_longitude1orientacao")
	private String longitude1Orientacao; 
	
	@Column (name = "d20_longitude2grau") 
	private Integer longitude2Grau; 
	
	@Column (name = "d20_longitude2minuto")
	private Integer longitude2Minuto; 
	
	@Column (name = "d20_longitude2orientacao")
	private String longitude2Orientacao; 
	
	@Column (name = "d20_precipmediaanualmm")
	private Integer precipMediaAnualmm; 
	
	@Column (name = "d20_precipmediamensalchuvamm")
	private Integer precipMediaMensalChuvamm; 
	
	@Column (name = "d20_precipmediamensalsecamm")
	private Integer precipMediaMensalSecamm;
	
	@Column (name = "d20_mesesseca")
	private String mesesSeca; 
	
	@Column (name = "d20_meseschuva")
	private String mesesChuva; 
	
	@Column (name = "d20_tipologiaflorestal")
	private String tipoLogiaFlorestal;
	
	@Column (name = "d20_tiposolo")
	private String tipoSolo;
	
	@Column (name = "d20_relevo")
	private String relevo; 
	
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
	
	
	@Column (name = "d20_lgmudacontada")
	private Boolean lgMudaContada; 
	
	@Column (name = "d20_lgpalmeiracontada")
	private Boolean lgPalmeiraContada; 
	

	public long getCdarea() {
		return cdarea;
	}

	public void setCdarea(long cdarea) {
		this.cdarea = cdarea;
	}

	public CadListaEspecie getCdListaEsp() {
		return cdListaEsp;
	}

	public void setCdListaEsp(CadListaEspecie cdListaEsp) {
		this.cdListaEsp = cdListaEsp;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public long getCdEquacaoAreaBasalPadrao() {
		return cdEquacaoAreaBasalPadrao;
	}

	public void setCdEquacaoAreaBasalPadrao(long cdEquacaoAreaBasalPadrao) {
		this.cdEquacaoAreaBasalPadrao = cdEquacaoAreaBasalPadrao;
	}

	public long getCdEquacaovolumeinvtemp() {
		return cdEquacaovolumeinvtemp;
	}

	public void setCdEquacaovolumeinvtemp(long cdEquacaovolumeinvtemp) {
		this.cdEquacaovolumeinvtemp = cdEquacaovolumeinvtemp;
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

	public Integer getLatitude1Grau() {
		return latitude1Grau;
	}

	public void setLatitude1Grau(Integer latitude1Grau) {
		this.latitude1Grau = latitude1Grau;
	}

	public Integer getLatitude1Minuto() {
		return latitude1Minuto;
	}

	public void setLatitude1Minuto(Integer latitude1Minuto) {
		this.latitude1Minuto = latitude1Minuto;
	}

	public String getLatitude1Orientacao() {
		return latitude1Orientacao;
	}

	public void setLatitude1Orientacao(String latitude1Orientacao) {
		this.latitude1Orientacao = latitude1Orientacao;
	}

	public Integer getLatitude2Grau() {
		return latitude2Grau;
	}

	public void setLatitude2Grau(Integer latitude2Grau) {
		this.latitude2Grau = latitude2Grau;
	}

	public Integer getLatitude2Minuto() {
		return latitude2Minuto;
	}

	public void setLatitude2Minuto(Integer latitude2Minuto) {
		this.latitude2Minuto = latitude2Minuto;
	}

	public String getLatitude2Orientacao() {
		return latitude2Orientacao;
	}

	public void setLatitude2Orientacao(String latitude2Orientacao) {
		this.latitude2Orientacao = latitude2Orientacao;
	}

	public Integer getLongitude1Grau() {
		return longitude1Grau;
	}

	public void setLongitude1Grau(Integer longitude1Grau) {
		this.longitude1Grau = longitude1Grau;
	}

	public Integer getLongitude1Minuto() {
		return longitude1Minuto;
	}

	public void setLongitude1Minuto(Integer longitude1Minuto) {
		this.longitude1Minuto = longitude1Minuto;
	}

	public String getLongitude1Orientacao() {
		return longitude1Orientacao;
	}

	public void setLongitude1Orientacao(String longitude1Orientacao) {
		this.longitude1Orientacao = longitude1Orientacao;
	}

	public Integer getLongitude2Grau() {
		return longitude2Grau;
	}

	public void setLongitude2Grau(Integer longitude2Grau) {
		this.longitude2Grau = longitude2Grau;
	}

	public Integer getLongitude2Minuto() {
		return longitude2Minuto;
	}

	public void setLongitude2Minuto(Integer longitude2Minuto) {
		this.longitude2Minuto = longitude2Minuto;
	}

	public String getLongitude2Orientacao() {
		return longitude2Orientacao;
	}

	public void setLongitude2Orientacao(String longitude2Orientacao) {
		this.longitude2Orientacao = longitude2Orientacao;
	}

	public Integer getPrecipMediaAnualmm() {
		return precipMediaAnualmm;
	}

	public void setPrecipMediaAnualmm(Integer precipMediaAnualmm) {
		this.precipMediaAnualmm = precipMediaAnualmm;
	}

	public Integer getPrecipMediaMensalChuvamm() {
		return precipMediaMensalChuvamm;
	}

	public void setPrecipMediaMensalChuvamm(Integer precipMediaMensalChuvamm) {
		this.precipMediaMensalChuvamm = precipMediaMensalChuvamm;
	}

	public Integer getPrecipMediaMensalSecamm() {
		return precipMediaMensalSecamm;
	}

	public void setPrecipMediaMensalSecamm(Integer precipMediaMensalSecamm) {
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
		return relevo;
	}

	public void setRelevo(String relevo) {
		this.relevo = relevo;
	}

	public String getMnResponsavel() {
		return mnResponsavel;
	}

	public void setMnResponsavel(String mnResponsavel) {
		this.mnResponsavel = mnResponsavel;
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

	public Boolean getLgMudaContada() {
		return lgMudaContada;
	}

	public void setLgMudaContada(Boolean lgMudaContada) {
		this.lgMudaContada = lgMudaContada;
	}

	public Boolean getLgPalmeiraContada() {
		return lgPalmeiraContada;
	}

	public void setLgPalmeiraContada(Boolean lgPalmeiraContada) {
		this.lgPalmeiraContada = lgPalmeiraContada;
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
