package org.sistcoop.credito.models.jpa;

import java.math.BigDecimal;

import org.sistcoop.credito.models.CreditoModel;
import org.sistcoop.credito.models.PlanPagoModel;

public class PlanPagoAdapter implements PlanPagoModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getCapital() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getInteres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getSeguro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getEstado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CreditoModel getCredito() {
		// TODO Auto-generated method stub
		return null;
	}

}
