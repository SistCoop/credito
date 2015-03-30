package org.sistcoop.credito.models.utils;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.sistcoop.credito.models.PersonaJuridicaModel;
import org.sistcoop.credito.models.PersonaJuridicaProvider;
import org.sistcoop.credito.models.PersonaNaturalModel;
import org.sistcoop.credito.models.PersonaNaturalProvider;
import org.sistcoop.credito.models.TipoDocumentoModel;
import org.sistcoop.credito.models.TipoDocumentoProvider;
import org.sistcoop.credito.models.enums.EstadoCivil;
import org.sistcoop.credito.models.enums.Sexo;
import org.sistcoop.credito.models.enums.TipoEmpresa;
import org.sistcoop.credito.models.enums.TipoPersona;
import org.sistcoop.credito.representations.idm.PersonaJuridicaRepresentation;
import org.sistcoop.credito.representations.idm.PersonaNaturalRepresentation;
import org.sistcoop.credito.representations.idm.TipoDocumentoRepresentation;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RepresentationToModel {
		
	public TipoDocumentoModel createTipoDocumento(TipoDocumentoRepresentation rep, TipoDocumentoProvider provider) {
		TipoDocumentoModel model = provider.addTipoDocumento(
				rep.getAbreviatura(), 
				rep.getDenominacion(), 
				rep.getCantidadCaracteres(), 
				TipoPersona.valueOf(rep.getTipoPersona()));	
		return model;
	}
		
	public PersonaNaturalModel createPersonaNatural(
			PersonaNaturalRepresentation rep, 
			TipoDocumentoModel tipoDocumentoModel, 
			PersonaNaturalProvider personaNaturalProvider) {		

		PersonaNaturalModel model = personaNaturalProvider.addPersonaNatural(
				rep.getCodigoPais(), 
				tipoDocumentoModel, 
				rep.getNumeroDocumento(), 
				rep.getApellidoPaterno(), 
				rep.getApellidoMaterno(), 
				rep.getNombres(), 
				rep.getFechaNacimiento(), 
				Sexo.valueOf(rep.getSexo().toUpperCase()));		

		model.setEstadoCivil(rep.getEstadoCivil() != null ? EstadoCivil.valueOf(rep.getEstadoCivil().toUpperCase()) : null);		
		model.setOcupacion(rep.getOcupacion());
		model.setUrlFoto(rep.getUrlFoto());
		model.setUrlFirma(rep.getUrlFirma());
		model.setUbigeo(rep.getUbigeo());
		model.setDireccion(rep.getDireccion());
		model.setReferencia(rep.getReferencia());
		model.setTelefono(rep.getTelefono());
		model.setCelular(rep.getCelular());
		model.setEmail(rep.getEmail());

		model.commit();
		return model;
	}
	
	public PersonaJuridicaModel createPersonaJuridica(
			PersonaJuridicaRepresentation rep, 			
			TipoDocumentoModel tipoDocumentoModel, 
			PersonaNaturalModel representanteLegal, 
			PersonaJuridicaProvider personaJuridicaProvider) {

		PersonaJuridicaModel model = personaJuridicaProvider.addPersonaJuridica(
				representanteLegal, 
				rep.getCodigoPais(), 
				tipoDocumentoModel, 
				rep.getNumeroDocumento(), 
				rep.getRazonSocial(), 
				rep.getFechaConstitucion(), 
				TipoEmpresa.valueOf(rep.getTipoEmpresa().toUpperCase()),
				rep.isFinLucro());
		
		model.setActividadPrincipal(rep.getActividadPrincipal());
		model.setNombreComercial(rep.getNombreComercial());
		
		model.setUbigeo(rep.getUbigeo());
		model.setDireccion(rep.getDireccion());
		model.setReferencia(rep.getReferencia());
		model.setTelefono(rep.getTelefono());
		model.setCelular(rep.getCelular());
		model.setEmail(rep.getEmail());

		model.commit();		
		return model;
	}

}
