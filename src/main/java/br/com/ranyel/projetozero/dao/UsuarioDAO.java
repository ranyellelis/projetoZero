package br.com.ranyel.projetozero.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.ranyel.projetozero.dao.repository.UsuarioRepository;
import br.com.ranyel.projetozero.domain.Usuario;
import br.com.ranyel.projetozero.exception.DaoException;

@RequestScoped
public class UsuarioDAO extends GenericHibernateDAO<Usuario, Long> implements UsuarioRepository {

	@Override
	public void salvar(Usuario usuario) throws DaoException {
		save(usuario);
	}

	@Override
	public List<Usuario> pesquisarTodosOsUsuarios() throws DaoException {
		return em.createQuery("select distinct u from Usuario u left join fetch u.perfilList", Usuario.class).getResultList();
	}

	@Override
	public void excluirUsuario(Usuario usuario) throws DaoException {
		delete(usuario);
	}	
}
