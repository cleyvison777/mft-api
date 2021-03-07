package com.embrapa.mft.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CadMedicao.class)
public abstract class CadMedicao_ {

	public static volatile SingularAttribute<CadMedicao, CadEmpresa> cdEmpresa;
	public static volatile SingularAttribute<CadMedicao, Date> dtInicioMedica;
	public static volatile SingularAttribute<CadMedicao, Long> cdMedicao;
	public static volatile SingularAttribute<CadMedicao, String> txObservacao;
	public static volatile SingularAttribute<CadMedicao, CadAmf> cdArea;

}

