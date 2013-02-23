package br.com.ranyel.projetozero.exception;

/**
 * @author ranyel
 * Exceção padrão para tratamento de erros da camada Service.
 */
public class ServiceException extends Exception {

	/**
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padrão.
	 */
	public ServiceException() {
		super();
	}

	/**
	 * Construtor sobrecarregado.
	 * @param message mensagem.
	 * @param cause causa.
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construtor sobrecarregado.
	 * @param message mensagem.
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * Construtor sobrecarregado.
	 * @param cause causa.
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}
}
