package br.com.ranyel.projetozero.domain.iface;

import java.io.Serializable;

public interface BaseEntity<T> extends Serializable {

	T getId();
	void setId(T id);
}
