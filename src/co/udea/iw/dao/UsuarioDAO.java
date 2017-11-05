package co.udea.iw.dao;

import co.udea.iw.dto.Usuario;
import co.udea.iw.exception.IWDaoException;
/**
 * 
 * @author Eduardo B , Yesid M
 * Interfaz que contiene la estructura de los metos a implementar en la clase UsuarioDAOHibernate
 */
public interface UsuarioDAO {
	/**
	 * Definición del método para obtener un usuario por su nombre de usuario en el sistema
	 * @param nombre nombre o alias del usuario
	 * @return objeto de tipo Usuario
	 * @throws IWDaoException
	 */
	public Usuario obtener(String nombre) throws IWDaoException;
	/**
	 * Definición del método que permite agregar un nuevo usuario al sistema
	 * @param usuario objeto de tipo Usuario
	 * @return Usuario con los datos a ser insertados
	 * @throws IWDaoException
	 */
	public Usuario insertar(Usuario usuario) throws IWDaoException;
	/**
	 * Definición del método que permite modificar a contraseña de un usuario
	 * @param nombre nombre o alias del usuario al cua se quiere cambiar la contraseña
	 * @param pwd contraseña nueva que sobreescribira a la anterior contraseña
	 * @return Usuario al que se le modificará la contraseña
	 * @throws IWDaoException
	 */
	public Usuario modificar(String nombre, String pwd) throws IWDaoException;
	/**
	 * Definición del método que permite eliminar un usuario
	 * @param usuario que se va a eliminar
	 * @throws IWDaoException
	 */
	public void eliminar(Usuario usuario) throws IWDaoException;
	/**
	 * Definición del método que permite verificar y validar el acceso de un usuario al sistema a través de su nombre y su contraseña
	 * @param nombre nombre o alias de lusuario en el sistema
	 * @param pwd contraseña del usuario
	 * @return cadena de caractéres informando si el inicio de sesión es correcto o no
	 * @throws IWDaoException
	 */
	public String login (String nombre, String pwd) throws IWDaoException;
}
