package org.sistcoop.credito.models;

import java.math.BigDecimal;
import java.util.Date;

public interface CreditoModel extends Model{

	Long getId();
	
	String getTipoDocumento();
	
	void setTipoDocumento();
	
	String getNumeroDocumento();
	
	void setNumeroDocumento();
	
	String getCodigoProducto();
	
	void setCodigoProducto();
	
	Integer getNumeroCuotas();
	
	void setNumeroCuotas();
	
	String getFrecuenciaPago();
	
	void setFrecuenciaPago();
	
	String getMoneda();
	
	BigDecimal getMonto();
	
	Integer getPlazoGracia();
	
	void setPlazoGracia();
	
	Date getFechaDesembolso();
	
	void setFechaDesembolso();
	
	boolean getEstado();
	
	void setEstado();
	
}
