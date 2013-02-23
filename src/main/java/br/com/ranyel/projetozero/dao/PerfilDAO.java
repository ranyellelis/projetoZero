package br.com.ranyel.projetozero.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.ranyel.projetozero.dao.repository.PerfilRepository;
import br.com.ranyel.projetozero.domain.Perfil;
import br.com.ranyel.projetozero.exception.DaoException;

@RequestScoped
public class PerfilDAO extends GenericHibernateDAO<Perfil, Long> implements
		PerfilRepository {

	@Override
	public List<Perfil> pesquisarTodosOsPerfis() throws DaoException {
		return findAll();
	}
}
