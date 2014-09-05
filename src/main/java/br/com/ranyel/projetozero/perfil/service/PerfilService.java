package br.com.ranyel.projetozero.perfil.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;

import br.com.ranyel.projetozero.EntityManagerService;
import br.com.ranyel.projetozero.domain.Perfil;
import br.com.ranyel.projetozero.exception.ServiceException;
import br.com.ranyel.projetozero.perfil.dao.repository.PerfilRepository;

/**
 * @author ranyel
 * Classe Service (Camada de negócio) para o objeto Perfil, 
 * que contém métodos transacionais gerenciados pelo container.
 */
@Stateful
@ConversationScoped
public class PerfilService extends EntityManagerService implements Serializable {

	/**
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * perfilRepository.
	 */
	@Inject
	private PerfilRepository perfilRepository;
	
	/**
	 * Salva o perfil passado como parâmetro.
	 * @param usuario perfil.
	 * @throws ServiceException Exceção da camada de negócio.
	 */
	public void salvar(Perfil usuario) throws ServiceException {
		try {
			perfilRepository.salvar(usuario);
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
	 * Exclui o perfil passado como parâmetro.
	 * @param usuario.
	 * @throws ServiceException Exceção da camada de negócio.
	 */
	public void excluirPerfil(Perfil usuario) throws ServiceException {
		try {
			perfilRepository.excluirPerfil(usuario);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
}