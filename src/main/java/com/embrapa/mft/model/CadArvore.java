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
@Table(name = "p23_arvore")
public class CadArvore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p23_cdarvore")
	private long cdArvore;
	
	@ManyToOne
	@JoinColumn(name = "p23_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@Column(name = "p23_cdarea")
	private long cdArea;
	
	@Column(name = "p23_cdmedicao")
	private long cdMedicao;
	
	@Column(name = "p23_cdparcela")
	private long cdParcela;
	
	@Column(name = "p23_cdsubparcela")
	private long cdSubparcela;
	
	@Column(name = "p23_cdespecie")
	private long cdEspecie;
	
	@Column(name = "p23_cdclassetamanho")
	private long cdClassetamanho;
	
	@Column(name = "p23_cdcif")
	 private long cdCif;
	
	@Column(name = "p23_cddano")
	private long cdDano;
	
	@Column(name = "p23_cdpodridao")
	 private long cdPodridao;

	
	@Column(name = "p23_cdiluminacao")
	 private long cdIluminacao;

	@Column(name = "p23_cdforma")
	 private long cdForma;

	
	@Column(name = "p23_cdcipo")
	 private long cdCipo;
	
	@Column(name = "p23_cdtratamento")
	private long cdTratamento;
	
	@Column(name = "p23_nrindividuo")
	private Integer nrIndividuo;
	
	@Column(name = "p23_nrfuste")
     private Integer nrFuste;
	
	@Column(name = "diametromm")
	private Integer Diametromm;
	
	@Column(name = "p23_coordx")
	private Integer coOrdx;
	
	@Column(name = "p23_coordy")
	private Integer cOordy;
	
	@Column(name = "p23_lgmudancapdm")
	private Integer lgMudanCapdm;

	@Column(name = "p23_volumetmp")
    private double  volumeTmp;
	
	@Column(name = "p23_areabasaltmp")
	private double   areaBasalTmp;

	public long getCdArvore() {
		return cdArvore;
	}

	public void setCdArvore(long cdArvore) {
		this.cdArvore = cdArvore;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public long getCdArea() {
		return cdArea;
	}

	public void setCdArea(long cdArea) {
		this.cdArea = cdArea;
	}

	public long getCdMedicao() {
		return cdMedicao;
	}

	public void setCdMedicao(long cdMedicao) {
		this.cdMedicao = cdMedicao;
	}

	public long getCdParcela() {
		return cdParcela;
	}

	public void setCdParcela(long cdParcela) {
		this.cdParcela = cdParcela;
	}

	public long getCdSubparcela() {
		return cdSubparcela;
	}

	public void setCdSubparcela(long cdSubparcela) {
		this.cdSubparcela = cdSubparcela;
	}

	public long getCdEspecie() {
		return cdEspecie;
	}

	public void setCdEspecie(long cdEspecie) {
		this.cdEspecie = cdEspecie;
	}

	public long getCdClassetamanho() {
		return cdClassetamanho;
	}

	public void setCdClassetamanho(long cdClassetamanho) {
		this.cdClassetamanho = cdClassetamanho;
	}

	public long getCdCif() {
		return cdCif;
	}

	public void setCdCif(long cdCif) {
		this.cdCif = cdCif;
	}

	public long getCdDano() {
		return cdDano;
	}

	public void setCdDano(long cdDano) {
		this.cdDano = cdDano;
	}

	public long getCdPodridao() {
		return cdPodridao;
	}

	public void setCdPodridao(long cdPodridao) {
		this.cdPodridao = cdPodridao;
	}

	public long getCdIluminacao() {
		return cdIluminacao;
	}

	public void setCdIluminacao(long cdIluminacao) {
		this.cdIluminacao = cdIluminacao;
	}

	public long getCdForma() {
		return cdForma;
	}

	public void setCdForma(long cdForma) {
		this.cdForma = cdForma;
	}

	public long getCdCipo() {
		return cdCipo;
	}

	public void setCdCipo(long cdCipo) {
		this.cdCipo = cdCipo;
	}

	public long getCdTratamento() {
		return cdTratamento;
	}

	public void setCdTratamento(long cdTratamento) {
		this.cdTratamento = cdTratamento;
	}

	public Integer getNrIndividuo() {
		return nrIndividuo;
	}

	public void setNrIndividuo(Integer nrIndividuo) {
		this.nrIndividuo = nrIndividuo;
	}

	public Integer getNrFuste() {
		return nrFuste;
	}

	public void setNrFuste(Integer nrFuste) {
		this.nrFuste = nrFuste;
	}

	public Integer getDiametromm() {
		return Diametromm;
	}

	public void setDiametromm(Integer diametromm) {
		Diametromm = diametromm;
	}

	public Integer getCoOrdx() {
		return coOrdx;
	}

	public void setCoOrdx(Integer coOrdx) {
		this.coOrdx = coOrdx;
	}

	public Integer getcOordy() {
		return cOordy;
	}

	public void setcOordy(Integer cOordy) {
		this.cOordy = cOordy;
	}

	public Integer getLgMudanCapdm() {
		return lgMudanCapdm;
	}

	public void setLgMudanCapdm(Integer lgMudanCapdm) {
		this.lgMudanCapdm = lgMudanCapdm;
	}

	public double getVolumeTmp() {
		return volumeTmp;
	}

	public void setVolumeTmp(double volumeTmp) {
		this.volumeTmp = volumeTmp;
	}

	public double getAreaBasalTmp() {
		return areaBasalTmp;
	}

	public void setAreaBasalTmp(double areaBasalTmp) {
		this.areaBasalTmp = areaBasalTmp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdArvore ^ (cdArvore >>> 32));
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
		CadArvore other = (CadArvore) obj;
		if (cdArvore != other.cdArvore)
			return false;
		return true;
	}

	

	



}
