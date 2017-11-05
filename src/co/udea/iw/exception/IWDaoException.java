package co.udea.iw.exception;

/**
 * 
 * @author Eduardo Bedoya, Yesid Montoya
 * Clase para manejar las excepciones del sistema
 *
 */
public class IWDaoException extends Exception {

	/**
	 * Excepción sin argmentos
	 */
	public IWDaoException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Excepccion con un argumento
	 * @param arg0 argumento de tipo string
	 */
	public IWDaoException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Excepcion  con un argumento
	 * @param arg0 superclase de los errores arrojados
	 */
	public IWDaoException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Excepción con dos argumentos
	 * @param arg0 argumento de tipo string
	 * @param arg1 superclase de los errores arrojados
	 */
	public IWDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Excepción con cuatro argumentos
	 * @param message argumento de tipo string
	 * @param cause superclase de los errores arrojados
	 * @param enableSuppression argumento de tipo booleano
	 * @param writableStackTrace argumento de tipo booleano
	 */
	public IWDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}