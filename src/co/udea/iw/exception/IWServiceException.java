package co.udea.iw.exception;

/**
 * 
 * @author Eduardo Bedoya, Yesid Montoya
 *Clase para controlar las excepciones creadas por los servicios de la app web
 */
public class IWServiceException extends Exception {

	/**
	 * Excepción con un argumento
	 */
	public IWServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * excepción con cuatro argumentos
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public IWServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Excepción con dos argumentos: un mensaje y la causa de la excepción
	 * @param message mensaje de error
	 * @param cause causa del error
	 */
	public IWServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Excepción con un argumento de mensaje de error
	 * @param message mensaje de error
	 */
	public IWServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Excepción con un argumento
	 * @param cause superclase de excepciones
	 */
	public IWServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}