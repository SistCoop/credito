package org.sistcoop.credito.models.jpa.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CREDITO", indexes = { @Index(columnList = "id") })
public class CreditoEntity {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String tipoDoc;
	private String numeroDoc;
	private String codigoProducto;
	private Integer numeroCuotas;
	private String frecuenciaPago;
	private String moneda;
	private BigDecimal monto;
	private Integer plazoGracia;
	private Date fechaDesembolso;
	private boolean estado;
	
	private Set<PlanPagoEntity> planPago = new HashSet<PlanPagoEntity>();
	private Set<CreditoTasaEntity> tasas = new HashSet<CreditoTasaEntity>();
	private Set<CreditoComisionEntity> comisiones = new HashSet<CreditoComisionEntity>();
	
	private Timestamp optlk;

	public CreditoEntity(){
		
	}
	
	
	@Id
	@GeneratedValue(generator = "SgGenericGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@Size(min = 1, max = 80)
	@NotEmpty
	@NotBlank
	@Column(name = "TIPO_DOCUMENTO", nullable = false)
	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	@NotNull
	@Size(min = 1, max = 20)
	@NotEmpty
	@NotBlank
	@Column(name = "NUMERO_DOCUMENTO")
	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	@NotNull
	@Size(min = 1, max = 100)
	@NotEmpty
	@NotBlank
	@Column(name = "CODIGO_PRODUCTO")
	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	
	@NotNull
	@NotEmpty
	public Integer getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(Integer numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 20)
	public String getFrecuenciaPago() {
		return frecuenciaPago;
	}

	public void setFrecuenciaPago(String frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago;
	}

	@NotNull
	@Size(min = 3, max = 3)
	@NotBlank
	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	@NotNull
	@Min(value = 0)
	@Max(value = 1000)
	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	@NotNull
	@NotEmpty
	public Integer getPlazoGracia() {
		return plazoGracia;
	}

	public void setPlazoGracia(Integer plazoGracia) {
		this.plazoGracia = plazoGracia;
	}

	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_DESEMBOLSO", nullable = false)
	public Date getFechaDesembolso() {
		return fechaDesembolso;
	}

	public void setFechaDesembolso(Date fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}

	@NotNull
	@Type(type = "org.hibernate.type.TrueFalseType")
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "credito")
	public Set<PlanPagoEntity> getPlanPago() {
		return planPago;
	}

	public void setPlanPago(Set<PlanPagoEntity> planPago) {
		this.planPago = planPago;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "credito")
	public Set<CreditoTasaEntity> getTasas() {
		return tasas;
	}

	public void setTasas(Set<CreditoTasaEntity> tasas) {
		this.tasas = tasas;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "credito")
	public Set<CreditoComisionEntity> getComisiones() {
		return comisiones;
	}

	public void setComisiones(Set<CreditoComisionEntity> comisiones) {
		this.comisiones = comisiones;
	}

	@Version
	public Timestamp getOptlk() {
		return optlk;
	}

	public void setOptlk(Timestamp optlk) {
		this.optlk = optlk;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PlanPagoEntity))
			return false;
		PlanPagoEntity other = (PlanPagoEntity) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}

}
