package com.joaquimsn.apibase.domain.main.persistence;

import com.joaquimsn.apibase.domain.main.enums.TypeStatus;

public interface DeletableEntity {

	public TypeStatus getStatus();

	public void setStatus(TypeStatus status);
}
