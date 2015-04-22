package org.sistcoop.credito.models.jpa.entities;



import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PLANPAGO", indexes = { @Index(columnList = "id") })
public class PlanPagoEntity {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private BigDecimal capital;
	private BigDecimal interes;
	private BigDecimal seguro;
	private boolean estado;
	private CreditoEntity credito;
	
	private Timestamp optlk;
	
	public PlanPagoEntity() {
		
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
	@Min(value = 0)
	@Max(value = 1000)
	public BigDecimal getCapital() {
		return capital;
	}
	
	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}
	
	@NotNull
	@Min(value = 0)
	@Max(value = 1000)
	public BigDecimal getInteres() {
		return interes;
	}
	
	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}
	
	@NotNull
	@Min(value = 0)
	@Max(value = 1000)
	public BigDecimal getSeguro() {
		return seguro;
	}
	
	public void setSeguro(BigDecimal seguro) {
		this.seguro = seguro;
	}
	
	@NotNull
	@Type(type = "org.hibernate.type.TrueFalseType")
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey)
	public CreditoEntity getCredito() {
		return credito;
	}

	public void setCredito(CreditoEntity credito) {
		this.credito = credito;
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
