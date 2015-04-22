package org.sistcoop.credito.models.jpa.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "CREDITO_TASA", indexes = { @Index(columnList = "id") })
public class CreditoTasaEntity {

	private Integer id;
	private BigDecimal valor;
	private String tasa;
	private CreditoEntity credito;

	@Id
	@GeneratedValue(generator = "SgGenericGenerator")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@NotNull
	@Size(min = 1, max = 100)
	@NotBlank
	public String getTasa() {
		return tasa;
	}

	public void setTasa(String tasa) {
		this.tasa = tasa;
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
		if (!(obj instanceof CreditoTasaEntity))
			return false;
		CreditoTasaEntity other = (CreditoTasaEntity) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}

	
}
