package com.joaquimsn.apibase.domain.main.persistence;

public interface Mergeable {

	<T> T merge(T revision);
}
