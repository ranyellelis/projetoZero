package br.com.ranyel.projetozero.dao.repository;

import java.util.List;

import br.com.ranyel.projetozero.domain.Usuario;
import br.com.ranyel.projetozero.exception.RepositoryException;

/**
 * @author ranyel
 * Uso do pattern Repository, para a classe de domínio Usuario.
 */
public interface UsuarioRepository {
	
	/**
	 * Salva um usuário.
	 * @param usuario usuario.
	 * @exception RepositoryException repositoryException.
	 */
	void salvar(Usuario usuario) throws RepositoryException;
	
	/**
	 * Pesquisa por todos os usuários cadastrados.
	 * @return lista de usuários.
	 * @exception RepositoryException repositoryException.
	 */
	List<Usuario> pesquisarTodosOsUsuarios() throws RepositoryException;
	
	/**
	 * Excluir o usuário passado como parâmetro.
	 * @param usuario usuário.
	 */
	void excluirUsuario(Usuario usuario) throws RepositoryException;
}
