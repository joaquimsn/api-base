package br.sp.senac.apibase.domain.main.persistence;

public interface Mergeable {

	<T> T merge(T revision);
}
