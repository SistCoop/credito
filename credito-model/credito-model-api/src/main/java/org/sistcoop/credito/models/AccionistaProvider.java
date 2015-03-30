package org.sistcoop.credito.models;

import java.math.BigDecimal;

import javax.ejb.Local;

import org.sistcoop.credito.provider.Provider;

@Local
public interface AccionistaProvider extends Provider {

	AccionistaModel addAccionista(PersonaJuridicaModel pjModel, PersonaNaturalModel pnModel, BigDecimal porcentaje);

	boolean removeAccionista(AccionistaModel accionistaModel);

	AccionistaModel getAccionistaById(Long id);

}
