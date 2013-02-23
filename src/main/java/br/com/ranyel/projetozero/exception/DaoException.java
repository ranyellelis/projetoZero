package br.com.ranyel.projetozero.exception;

/**
 * @author ranyel
 * Exceção padrão para objetos que implementam o 'pattern' DAO.
 */
public class DaoException extends RepositoryException {

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor padrão.
	 */
	public DaoException() {
		super();
	}

	/**
	 * Construtor sobrecarregado.
	 * @param message mensagem.
	 * @param cause causa.
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construtor sobrecarregado.
	 * @param message mensagem.
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * Construtor sobrecarregado.
	 * @param cause causa.
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}
}