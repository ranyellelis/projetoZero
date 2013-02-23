package br.com.ranyel.projetozero.exception;

/**
 * @author ranyel
 * Exceção padrão para objetos que implementam o 'pattern' Repository.
 */
public class RepositoryException extends Exception {

	/**
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padrão.
	 */
	public RepositoryException() {
		super();
	}

	/**
	 * Construtor sobrecarregado.
	 * @param message mensagem.
	 * @param cause causa.
	 */
	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construtor sobrecarregado.
	 * @param message mensagem.
	 */
	public RepositoryException(String message) {
		super(message);
	}

	/**
	 * Construtor sobrecarregado.
	 * @param cause causa.
	 */
	public RepositoryException(Throwable cause) {
		super(cause);
	}
}
