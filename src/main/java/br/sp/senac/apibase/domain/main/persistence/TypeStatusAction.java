package br.sp.senac.apibase.domain.main.persistence;

import br.sp.senac.apibase.domain.main.enums.TypeStatus;

public interface TypeStatusAction {

	public TypeStatus getStatus();

	public void setStatus(TypeStatus status);

	public default void inverterStatus() {
		setStatus(TypeStatus.inverterStatus(getStatus()));
	}
}
