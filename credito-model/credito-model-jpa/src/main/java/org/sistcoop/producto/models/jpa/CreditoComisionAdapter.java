package org.sistcoop.producto.models.jpa;

import java.math.BigDecimal;

import org.sistcoop.credito.models.CreditoComisionModel;
import org.sistcoop.credito.models.CreditoModel;
import org.sistcoop.credito.models.enums.Frecuencia;
import org.sistcoop.credito.models.enums.TipoValor;

public class CreditoComisionAdapter implements CreditoComisionModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDenominacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getValor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoValor getTipoValor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Frecuencia getFrecuencia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditoModel getCredito() {
		// TODO Auto-generated method stub
		return null;
	}

}
