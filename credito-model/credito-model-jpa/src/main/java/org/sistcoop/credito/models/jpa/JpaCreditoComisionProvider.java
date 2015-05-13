package org.sistcoop.credito.models.jpa;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;

import org.sistcoop.credito.models.CreditoComisionProvider;


@Named
@Stateless
@Local(CreditoComisionProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaCreditoComisionProvider implements CreditoComisionProvider{

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
