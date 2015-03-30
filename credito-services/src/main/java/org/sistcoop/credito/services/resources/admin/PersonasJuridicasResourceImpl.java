package org.sistcoop.credito.services.resources.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.sistcoop.credito.models.PersonaJuridicaModel;
import org.sistcoop.credito.models.PersonaJuridicaProvider;
import org.sistcoop.credito.models.utils.ModelToRepresentation;
import org.sistcoop.credito.representations.idm.PersonaJuridicaRepresentation;
import org.sistcoop.persona.admin.client.resource.PersonasJuridicasResource;

@Stateless
public class PersonasJuridicasResourceImpl implements PersonasJuridicasResource {

	@Inject
	protected PersonaJuridicaProvider personaJuridicaProvider;

	@Override
	public List<PersonaJuridicaRepresentation> findAll(String filterText, Integer firstResult, Integer maxResults) {
		filterText = (filterText == null ? "" : filterText);
		firstResult = (firstResult == null ? -1 : firstResult);
		maxResults = (maxResults == null ? -1 : maxResults);

		List<PersonaJuridicaModel> list = personaJuridicaProvider.searchForFilterText(filterText, firstResult, maxResults);
		List<PersonaJuridicaRepresentation> result = new ArrayList<PersonaJuridicaRepresentation>();
		for (PersonaJuridicaModel model : list) {
			result.add(ModelToRepresentation.toRepresentation(model));
		}
		return result;
	}

	@Override
	public long countAll() {
		Long count = personaJuridicaProvider.getPersonasJuridicasCount();
		return count;
	}

}
