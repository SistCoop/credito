package org.sistcoop.credito.models;

import java.math.BigDecimal;

public interface CreditoTasaModel extends Model{

	
	Integer getId();
	
	BigDecimal getValor();
	
	String getTasa();
	
	CreditoModel getCredito();
	
	
}
