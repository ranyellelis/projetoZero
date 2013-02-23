package br.com.ranyel.projetozero.dao.repository;

import java.util.List;

import br.com.ranyel.projetozero.domain.Perfil;
import br.com.ranyel.projetozero.exception.DaoException;

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
}
