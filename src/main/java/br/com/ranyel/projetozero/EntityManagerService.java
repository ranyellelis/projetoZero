package br.com.ranyel.projetozero;

import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
@ConversationScoped
public class EntityManagerService {
	
	/**
	 * EntityManager injetado pelo container em modo extendido.
	 */
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	/**
	 * Produtor de EntityManager.
	 * @return objeto entityManager.
	 */
	@Produces
	public EntityManager producer(){
		return em;
	}	
}
