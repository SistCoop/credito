package org.sistcoop.credito.models.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;


@Entity
@Table(name = "Garantia", indexes = { @Index(columnList = "id") })
public class Garantia {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
