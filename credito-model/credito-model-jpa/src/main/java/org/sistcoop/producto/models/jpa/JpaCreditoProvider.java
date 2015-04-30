package org.sistcoop.producto.models.jpa;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;

import org.sistcoop.credito.models.CreditoProvider;

@Named
@Stateless
@Local(CreditoProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaCreditoProvider implements CreditoProvider{

	@Override
	public void close() {
		
	}

}
