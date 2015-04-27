package org.sistcoop.credito.models;

import java.math.BigDecimal;

public interface PlanPagoModel extends Model{

	
	Long getId();
	
	BigDecimal getCapital();
	
	BigDecimal getInteres();
	
	BigDecimal getSeguro();
	
	boolean getEstado();
	
	CreditoModel getCredito();
}
