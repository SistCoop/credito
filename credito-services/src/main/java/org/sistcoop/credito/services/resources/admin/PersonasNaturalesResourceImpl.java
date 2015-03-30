package org.sistcoop.credito.services.resources.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.sistcoop.credito.models.PersonaNaturalModel;
import org.sistcoop.credito.models.PersonaNaturalProvider;
import org.sistcoop.credito.models.utils.ModelToRepresentation;
import org.sistcoop.credito.representations.idm.PersonaNaturalRepresentation;
import org.sistcoop.persona.admin.client.resource.PersonasNaturalesResource;

@Stateless
public class PersonasNaturalesResourceImpl implements PersonasNaturalesResource {

	@Inject
	protected PersonaNaturalProvider personaNaturalProvider;

	@Override
	public List<PersonaNaturalRepresentation> listAll(String filterText, Integer firstResult, Integer maxResults) {
		List<PersonaNaturalRepresentation> results = new ArrayList<PersonaNaturalRepresentation>();
		List<PersonaNaturalModel> userModels;
		if (filterText == null) {
			if (firstResult == null || maxResults == null) {
				userModels = personaNaturalProvider.getPersonasNaturales();
			} else {
				userModels = personaNaturalProvider.getPersonasNaturales(firstResult, maxResults);
			}
		} else {
			if (firstResult == null || maxResults == null) {
				userModels = personaNaturalProvider.searchForFilterText(filterText);
			} else {
				userModels = personaNaturalProvider.searchForFilterText(filterText, firstResult, maxResults);
			}
		}
		for (PersonaNaturalModel personaNaturalModel : userModels) {
			results.add(ModelToRepresentation.toRepresentation(personaNaturalModel));
		}
		return results;
	}

	@Override
	public long countAll() {
		return personaNaturalProvider.getPersonasNaturalesCount();
	}

}
