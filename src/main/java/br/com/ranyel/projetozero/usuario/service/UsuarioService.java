package br.com.ranyel.projetozero.usuario.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.ranyel.projetozero.EntityManagerService;
import br.com.ranyel.projetozero.domain.Perfil;
import br.com.ranyel.projetozero.domain.Usuario;
import br.com.ranyel.projetozero.exception.ServiceException;
import br.com.ranyel.projetozero.perfil.dao.repository.PerfilRepository;
import br.com.ranyel.projetozero.usuario.dao.repository.UsuarioRepository;

/**
 * @author ranyel
 * Classe Service (Camada de negócio) para o objeto Usuario, 
 * que contém métodos transacionais gerenciados pelo container.
 */
@Stateful
@ConversationScoped
public class UsuarioService extends EntityManagerService implements Serializable {

	/**
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * usuarioRepository.
	 */
	@Inject
	private UsuarioRepository usuarioRepository;

	/**
	 * perfilRepository.
	 */
	@Inject
	private PerfilRepository perfilRepository;

	
	/**
	 * Salva o usuário passado como parâmetro.
	 * @param usuario usuário.
	 * @throws ServiceException Exceção da camada de negócio.
	 */
	public void salvar(Usuario usuario) throws ServiceException {
		try {
			usuarioRepository.salvar(usuario);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Pesquisa todos os usuários cadastrados.
	 * @return lista de usuários.
	 * @throws ServiceException Exceção da camada de negócio.
	 */
	public List<Usuario> pesquisarTodosUsuarios() throws ServiceException {
		try {
			return usuarioRepository.pesquisarTodosOsUsuarios();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Pesquisa todos os perfis cadastrados.
	 * @return lista de perfis.
	 * @throws ServiceException Exceção da camada de negócio.
	 */
	public List<Perfil> pesquisarTodosPerfis() throws ServiceException {
		try {
			return perfilRepository.pesquisarTodosOsPerfis();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	/** 
	 * Exclui o usuário passado como parâmetro.
	 * @param usuario.
	 * @throws ServiceException Exceção da camada de negócio.
	 */
	public void excluirUsuario(Usuario usuario) throws ServiceException {
		try {
			usuarioRepository.excluirUsuario(usuario);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
}