package com.embrapa.mft.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "r33_area_classe_tamanho")
public class CadClasseDeTamanho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "r33_cdclassetamanho")
	private Long cdClasseTamanho;
		
	@ManyToOne
	@JoinColumn(name= "r33_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@ManyToOne
	@JoinColumn(name= "r33_cdarea")
	private CadAmf cdArea;

	@ManyToOne
	@JoinColumn(name= "r33_cdequacaovolumepadrao")
	private CadEquacao cdEquacao;
	
	@Column(name = "r33_dapminimocomfustemm")
	private Integer dapMinimoComFustemm;
	
	@Column(name = "r33_dapmaximocomfustemm")
	private Integer dapMaximoComFustemm;
	
	@Column(name = "r33_dapminimosemfustemm")
	private Integer dapMinimoSemFustemm;
	
	@Column(name = "r33_dapmaximosemfustemm")
	private Integer dapMaximoSemFustemm;
	
	@Column(name = "r33_alturaminimam")
	private BigDecimal alturaMinimam;
	
	@Column(name = "r33_alturamaximam")
	private BigDecimal alturaMaximam;
	
	@Column(name = "r33_comprimentoparcelam")
	private BigDecimal comprimentoParcelam;
	
	@Column(name = "r33_larguraparcelam")
	private BigDecimal larguraParcelam;
	
	@Column(name = "r33_cdformatosubparcela")
	private Integer r33_cdFormatoSubParcela;
	
	@Column(name = "r33_dimensao1subparcelam")
	private BigDecimal dimensao1SubParcelam;
	
	@Column(name = "r33_dimensao2subparcelam")
	private BigDecimal dimensao2SubParcelam;
	
	@Column(name = "r33_dimensao3subparcelam")
	private BigDecimal dimensao3SubParcelam;
	
	@Column(name = "r33_padraocrescanualminimomm")
	private Integer padraoCrescAnualMiniMomm;
	
	@Column(name = "r33_padraocrescanualmaximomm")
	private Integer padraoCrescAnualMaxiMomm;
	
	@Column(name = "r33_dapmaximoingmedicao2mm") 
	private Integer dapMaxiMoingMedicao2mm;
			
	@Column(name = "r33_nrsubparcelasporparcela")
	private Integer nrSubParcelasPorParcela;

	public Long getCdClasseTamanho() {
		return cdClasseTamanho;
	}

	public void setCdClasseTamanho(Long cdClasseTamanho) {
		this.cdClasseTamanho = cdClasseTamanho;
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

	public CadEquacao getCdEquacao() {
		return cdEquacao;
	}

	public void setCdEquacao(CadEquacao cdEquacao) {
		this.cdEquacao = cdEquacao;
	}

	public Integer getDapMinimoComFustemm() {
		return dapMinimoComFustemm;
	}

	public void setDapMinimoComFustemm(Integer dapMinimoComFustemm) {
		this.dapMinimoComFustemm = dapMinimoComFustemm;
	}

	public Integer getDapMaximoComFustemm() {
		return dapMaximoComFustemm;
	}

	public void setDapMaximoComFustemm(Integer dapMaximoComFustemm) {
		this.dapMaximoComFustemm = dapMaximoComFustemm;
	}

	public Integer getDapMinimoSemFustemm() {
		return dapMinimoSemFustemm;
	}

	public void setDapMinimoSemFustemm(Integer dapMinimoSemFustemm) {
		this.dapMinimoSemFustemm = dapMinimoSemFustemm;
	}

	public Integer getDapMaximoSemFustemm() {
		return dapMaximoSemFustemm;
	}

	public void setDapMaximoSemFustemm(Integer dapMaximoSemFustemm) {
		this.dapMaximoSemFustemm = dapMaximoSemFustemm;
	}

	public BigDecimal getAlturaMinimam() {
		return alturaMinimam;
	}

	public void setAlturaMinimam(BigDecimal alturaMinimam) {
		this.alturaMinimam = alturaMinimam;
	}

	public BigDecimal getAlturaMaximam() {
		return alturaMaximam;
	}

	public void setAlturaMaximam(BigDecimal alturaMaximam) {
		this.alturaMaximam = alturaMaximam;
	}

	public BigDecimal getComprimentoParcelam() {
		return comprimentoParcelam;
	}

	public void setComprimentoParcelam(BigDecimal comprimentoParcelam) {
		this.comprimentoParcelam = comprimentoParcelam;
	}

	public BigDecimal getLarguraParcelam() {
		return larguraParcelam;
	}

	public void setLarguraParcelam(BigDecimal larguraParcelam) {
		this.larguraParcelam = larguraParcelam;
	}

	public Integer getR33_cdFormatoSubParcela() {
		return r33_cdFormatoSubParcela;
	}

	public void setR33_cdFormatoSubParcela(Integer r33_cdFormatoSubParcela) {
		this.r33_cdFormatoSubParcela = r33_cdFormatoSubParcela;
	}

	public BigDecimal getDimensao1SubParcelam() {
		return dimensao1SubParcelam;
	}

	public void setDimensao1SubParcelam(BigDecimal dimensao1SubParcelam) {
		this.dimensao1SubParcelam = dimensao1SubParcelam;
	}

	public BigDecimal getDimensao2SubParcelam() {
		return dimensao2SubParcelam;
	}

	public void setDimensao2SubParcelam(BigDecimal dimensao2SubParcelam) {
		this.dimensao2SubParcelam = dimensao2SubParcelam;
	}

	public BigDecimal getDimensao3SubParcelam() {
		return dimensao3SubParcelam;
	}

	public void setDimensao3SubParcelam(BigDecimal dimensao3SubParcelam) {
		this.dimensao3SubParcelam = dimensao3SubParcelam;
	}

	public Integer getPadraoCrescAnualMiniMomm() {
		return padraoCrescAnualMiniMomm;
	}

	public void setPadraoCrescAnualMiniMomm(Integer padraoCrescAnualMiniMomm) {
		this.padraoCrescAnualMiniMomm = padraoCrescAnualMiniMomm;
	}

	public Integer getPadraoCrescAnualMaxiMomm() {
		return padraoCrescAnualMaxiMomm;
	}

	public void setPadraoCrescAnualMaxiMomm(Integer padraoCrescAnualMaxiMomm) {
		this.padraoCrescAnualMaxiMomm = padraoCrescAnualMaxiMomm;
	}

	public Integer getDapMaxiMoingMedicao2mm() {
		return dapMaxiMoingMedicao2mm;
	}

	public void setDapMaxiMoingMedicao2mm(Integer dapMaxiMoingMedicao2mm) {
		this.dapMaxiMoingMedicao2mm = dapMaxiMoingMedicao2mm;
	}

	public Integer getNrSubParcelasPorParcela() {
		return nrSubParcelasPorParcela;
	}

	public void setNrSubParcelasPorParcela(Integer nrSubParcelasPorParcela) {
		this.nrSubParcelasPorParcela = nrSubParcelasPorParcela;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdClasseTamanho == null) ? 0 : cdClasseTamanho.hashCode());
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
		CadClasseDeTamanho other = (CadClasseDeTamanho) obj;
		if (cdClasseTamanho == null) {
			if (other.cdClasseTamanho != null)
				return false;
		} else if (!cdClasseTamanho.equals(other.cdClasseTamanho))
			return false;
		return true;
	}
	
	
	
}
