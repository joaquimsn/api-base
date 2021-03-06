package com.joaquimsn.apibase.domain.main.persistence;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface UpdatableEntity<ID extends Serializable> extends Mergeable {
	
	ID getId();

	LocalDateTime getDataAlteracao();

	void setDataAlteracao(LocalDateTime dataAlteracao);

	default void actionPreUpdate() {
		setDataAlteracao(LocalDateTime.now());
	}

}
