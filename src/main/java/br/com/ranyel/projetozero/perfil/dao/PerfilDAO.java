package br.com.ranyel.projetozero.perfil.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.ranyel.projetozero.dao.GenericHibernateDAO;
import br.com.ranyel.projetozero.domain.Perfil;
import br.com.ranyel.projetozero.exception.DaoException;
import br.com.ranyel.projetozero.exception.RepositoryException;
import br.com.ranyel.projetozero.perfil.dao.repository.PerfilRepository;

@RequestScoped
public class PerfilDAO extends GenericHibernateDAO<Perfil, Long> implements
		PerfilRepository {

	@Override
	public List<Perfil> pesquisarTodosOsPerfis() throws DaoException {
		return findAll();
	}

	@Override
	public void salvar(Perfil perfil) throws RepositoryException {
		save(perfil);
	}

	@Override
	public void excluirPerfil(Perfil perfil) throws RepositoryException {
		delete(perfil);
	}
}
