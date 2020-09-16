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
@Table(name ="d36_tratamento_silvicultural")
public class CadTratamentoSilvicultural {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d36_cdtratamento")
	private long cdTratamento;
	
	@ManyToOne
	@JoinColumn(name = "d36_cdempresa")
	private CadEmpresa cdEmpresa;
	
	/*
	 * //@JsonIgnoreProperties("cdTratamentAnterior")
	 * 
	 * @Valid
	 * 
	 * @OneToMany(mappedBy = "cdTratamentAnterior", cascade = CascadeType.ALL,
	 * orphanRemoval = true) private List<CadTsAtualTsAnterior>
	 * cadTsAtualTsAnterior;
	 */
	
	

	@Column(name = "d36_nmtratamento")
	private String nmTratamento;
	/*
	 * 
	 * public List<CadTsAtualTsAnterior> getCdTratamentAnterior() { return
	 * cdTratamentAnterior; }
	 * 
	 * 
	 * public void setCdTratamentAnterior(List<CadTsAtualTsAnterior>
	 * cdTratamentAnterior) { this.cdTratamentAnterior = cdTratamentAnterior; }
	 */


	public long getCdTratamento() {
		return cdTratamento;
	}
	

	public void setCdTratamento(long cdTratamento) {
		this.cdTratamento = cdTratamento;
	}

	
	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}
	
	
	

	public String getNmTratamento() {
		return nmTratamento;
	}

	public void setNmTratamento(String nmTratamento) {
		this.nmTratamento = nmTratamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdTratamento ^ (cdTratamento >>> 32));
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
		CadTratamentoSilvicultural other = (CadTratamentoSilvicultural) obj;
		if (cdTratamento != other.cdTratamento)
			return false;
		return true;
	}

	
	
	
	
}
