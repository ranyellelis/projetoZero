package br.com.ranyel.projetozero.perfil.dao.repository;

import java.util.List;

import br.com.ranyel.projetozero.domain.Perfil;
import br.com.ranyel.projetozero.exception.DaoException;
import br.com.ranyel.projetozero.exception.RepositoryException;

/**
 * @author ranyel
 * Uso do pattern Repository, para a classe de domínio Perfil.
 */
public interface PerfilRepository {
	
	/**
	 * Pesquisa por todos os registros de Perfil.
	 * @return lista de objetos Perfil.
	 * @throws DaoException daoException. 
	 */
	List<Perfil> pesquisarTodosOsPerfis() throws DaoException;
	
	/**
	 * Salva um perfil.
	 * @param perfil perfil.
	 * @exception RepositoryException repositoryException.
	 */
	void salvar(Perfil perfil) throws RepositoryException;
	
	/**
	 * Excluir o perfil passado como parâmetro.
	 * @param perfil perfil.
	 */
	void excluirPerfil(Perfil perfil) throws RepositoryException;
}
