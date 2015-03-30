package org.sistcoop.credito.services.resources.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.sistcoop.credito.models.enums.EstadoCivil;
import org.sistcoop.credito.models.enums.Sexo;
import org.sistcoop.credito.models.enums.TipoEmpresa;
import org.sistcoop.credito.models.enums.TipoPersona;
import org.sistcoop.credito.representations.idm.EstadoCivilRepresentation;
import org.sistcoop.credito.representations.idm.SexoRepresentation;
import org.sistcoop.credito.representations.idm.TipoEmpresaRepresentation;
import org.sistcoop.credito.representations.idm.TipoPersonaRepresentation;
import org.sistcoop.persona.admin.client.resource.MaestroResource;

@Stateless
public class MaestroResourceImpl implements MaestroResource {

	public List<TipoPersonaRepresentation> getTipoPersonas() {
		TipoPersona[] s = TipoPersona.values();
		List<TipoPersonaRepresentation> list = new ArrayList<TipoPersonaRepresentation>();
		for (int i = 0; i < s.length; i++) {
			list.add(new TipoPersonaRepresentation(s[i].toString()));
		}
		return list;
	}

	public List<EstadoCivilRepresentation> getEstadosCiviles() {
		EstadoCivil[] e = EstadoCivil.values();
		List<EstadoCivilRepresentation> list = new ArrayList<EstadoCivilRepresentation>();
		for (int i = 0; i < e.length; i++) {
			list.add(new EstadoCivilRepresentation(e[i].toString()));
		}
		return list;
	}

	public List<SexoRepresentation> getSexos() {
		Sexo[] s = Sexo.values();
		List<SexoRepresentation> list = new ArrayList<SexoRepresentation>();
		for (int i = 0; i < s.length; i++) {
			list.add(new SexoRepresentation(s[i].toString()));
		}
		return list;
	}

	public List<TipoEmpresaRepresentation> getTiposEmpresa() {
		TipoEmpresa[] s = TipoEmpresa.values();
		List<TipoEmpresaRepresentation> list = new ArrayList<TipoEmpresaRepresentation>();
		for (int i = 0; i < s.length; i++) {
			list.add(new TipoEmpresaRepresentation(s[i].toString()));
		}
		return list;
	}

}
