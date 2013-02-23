package br.com.ranyel.projetozero.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import br.com.ranyel.projetozero.dao.iface.IGenericDAO;
import br.com.ranyel.projetozero.exception.DaoException;

/**
 * @author ranyel
 * 
 * @param <T> Classe de domínio.
 * @param <ID> id da classe de domínio.
 */
public abstract class GenericHibernateDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {
	
	@Inject
	protected EntityManager em;
	
	private Class<T> entityClass;

	@Override
	public void save(T obj) throws DaoException {
		try {
			em.merge(obj);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void delete(T obj) throws DaoException {
		try {
			em.remove(obj);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public T findById(ID id) throws DaoException {
		try {
			return em.find(getEntityClass(), id);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T example) throws DaoException {
		try {
			Criteria crit = getSession().createCriteria(getEntityClass());
			crit.add(Example.create(example).enableLike(MatchMode.ANYWHERE)
					.ignoreCase());
			return (List<T>) crit.list();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() throws DaoException {
		try {
			Criteria crit = getSession().createCriteria(getEntityClass());
			return (List<T>) crit.list();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByCriterions(List<Criterion> criterions) throws DaoException {
		try {
			Criteria crit = getSession().createCriteria(getEntityClass());
			for (Criterion criterion : criterions) {
				crit.add(criterion);
			}
			return (List<T>) crit.list();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	
	/**
	 * @return a Session do hibernate.
	 */
	private Session getSession() {
		 return (Session) em.getDelegate();
	}

	/**
	 * @return a classe da entidade genérica.
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
		if (entityClass == null) {
			Type type = getClass().getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				ParameterizedType paramType = (ParameterizedType) type;
				if (paramType.getActualTypeArguments().length == 2) {
					if (paramType.getActualTypeArguments()[0] instanceof TypeVariable) {
						throw new IllegalArgumentException(
								"Não foi possível encontrar classe de entidades por reflexão!");
					} else {
						entityClass = (Class<T>) paramType
								.getActualTypeArguments()[0];
					}
				} else {
					throw new IllegalArgumentException(
							"Não foi possível encontrar classe de entidades por reflexão!");
				}
			}
		}
		return entityClass;
	}
}