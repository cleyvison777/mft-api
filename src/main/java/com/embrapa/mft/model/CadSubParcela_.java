package com.embrapa.mft.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CadSubParcela.class)
public abstract class CadSubParcela_ {

	public static volatile SingularAttribute<CadSubParcela, CadEmpresa> cdEmpresa;
	public static volatile SingularAttribute<CadSubParcela, Long> cdSubParcela;
	public static volatile SingularAttribute<CadSubParcela, Long> id;
	public static volatile SingularAttribute<CadSubParcela, CadParcela> cdParcela;
	public static volatile SingularAttribute<CadSubParcela, CadAmf> cdArea;

}

