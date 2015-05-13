package org.sistcoop.credito.models.jpa;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sistcoop.credito.models.AvalProvider;

@Named
@Stateless
@Local(AvalProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaAvalProvider implements AvalProvider{

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
	}

}
