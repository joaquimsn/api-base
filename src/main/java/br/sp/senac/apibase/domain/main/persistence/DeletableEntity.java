package br.sp.senac.apibase.domain.main.persistence;

import br.sp.senac.apibase.domain.main.enums.TypeStatus;

public interface DeletableEntity {

	public TypeStatus getStatus();

	public void setStatus(TypeStatus status);
}
