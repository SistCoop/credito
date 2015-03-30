package org.sistcoop.credito.services.resources.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.sistcoop.credito.models.TipoDocumentoModel;
import org.sistcoop.credito.models.TipoDocumentoProvider;
import org.sistcoop.credito.models.enums.TipoPersona;
import org.sistcoop.credito.models.utils.ModelToRepresentation;
import org.sistcoop.credito.representations.idm.TipoDocumentoRepresentation;
import org.sistcoop.persona.admin.client.resource.TiposDocumentoResource;

@Stateless
public class TiposDocumentoResourceImpl implements TiposDocumentoResource {

	@Inject
	protected TipoDocumentoProvider tipoDocumentoProvider;

	@Override
	public List<TipoDocumentoRepresentation> findAll(String tipoPersona, Boolean estado) {
		List<TipoDocumentoModel> list = null;
		if (tipoPersona != null) {
			TipoPersona personType = TipoPersona.valueOf(tipoPersona.toUpperCase());
			if (personType != null) {
				list = tipoDocumentoProvider.getTiposDocumento(personType);
			} else {
				list = tipoDocumentoProvider.getTiposDocumento();
			}
		} else {
			list = tipoDocumentoProvider.getTiposDocumento();
		}

		List<TipoDocumentoRepresentation> result = new ArrayList<TipoDocumentoRepresentation>();
		for (TipoDocumentoModel model : list) {
			result.add(ModelToRepresentation.toRepresentation(model));
		}

		return result;
	}

}
