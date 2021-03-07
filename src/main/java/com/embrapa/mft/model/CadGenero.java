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
@Table(name="d02_genero")

public class CadGenero {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "d02_cdgenero")
 private long cdGenero;
 
 @Column(name = "d02_nmgenero")
 private String nmGenero;
 
 @ManyToOne
 @JoinColumn(name = "d02_cdfamilia")
 private CadFamilia cdFamilia;

public long getCdGenero() {
	return cdGenero;
}

public void setCdGenero(long cdGenero) {
	this.cdGenero = cdGenero;
}

public String getNmGenero() {
	return nmGenero;
}

public void setNmGenero(String nmGenero) {
	this.nmGenero = nmGenero;
}

public CadFamilia getCdFamilia() {
	return cdFamilia;
}

public void setCdFamilia(CadFamilia cdFamilia) {
	this.cdFamilia = cdFamilia;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (cdGenero ^ (cdGenero >>> 32));
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
	CadGenero other = (CadGenero) obj;
	if (cdGenero != other.cdGenero)
		return false;
	return true;
}





 
 
 
 

 

}
