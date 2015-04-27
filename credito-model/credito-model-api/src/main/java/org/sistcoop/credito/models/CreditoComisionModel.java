package org.sistcoop.credito.models;

import java.math.BigDecimal;

import org.sistcoop.credito.models.enums.Frecuencia;
import org.sistcoop.credito.models.enums.TipoValor;

public interface CreditoComisionModel extends Model{

	
	Integer getId();
	
	String getDenominacion();
	
	BigDecimal getValor();
	
	TipoValor getTipoValor();
	
	Frecuencia getFrecuencia();
	
	CreditoModel getCredito();
}
