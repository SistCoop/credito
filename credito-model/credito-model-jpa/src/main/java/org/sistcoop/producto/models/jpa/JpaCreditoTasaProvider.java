package org.sistcoop.producto.models.jpa;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;

import org.sistcoop.credito.models.CreditoTasaProvider;

@Named
@Stateless
@Local(CreditoTasaProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaCreditoTasaProvider implements CreditoTasaProvider{

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
