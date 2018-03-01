package com.joaquimsn.apibase.domain.main.persistence;

import com.joaquimsn.apibase.domain.main.enums.TypeStatus;

public interface TypeStatusAction {

	public TypeStatus getStatus();

	public void setStatus(TypeStatus status);

	public default void inverterStatus() {
		setStatus(TypeStatus.inverterStatus(getStatus()));
	}
}
