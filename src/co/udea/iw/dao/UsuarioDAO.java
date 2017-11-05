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
	 * Definici�n del m�todo para obtener un usuario por su nombre de usuario en el sistema
	 * @param nombre nombre o alias del usuario
	 * @return objeto de tipo Usuario
	 * @throws IWDaoException
	 */
	public Usuario obtener(String nombre) throws IWDaoException;
	/**
	 * Definici�n del m�todo que permite agregar un nuevo usuario al sistema
	 * @param usuario objeto de tipo Usuario
	 * @return Usuario con los datos a ser insertados
	 * @throws IWDaoException
	 */
	public Usuario insertar(Usuario usuario) throws IWDaoException;
	/**
	 * Definici�n del m�todo que permite modificar a contrase�a de un usuario
	 * @param nombre nombre o alias del usuario al cua se quiere cambiar la contrase�a
	 * @param pwd contrase�a nueva que sobreescribira a la anterior contrase�a
	 * @return Usuario al que se le modificar� la contrase�a
	 * @throws IWDaoException
	 */
	public Usuario modificar(String nombre, String pwd) throws IWDaoException;
	/**
	 * Definici�n del m�todo que permite eliminar un usuario
	 * @param usuario que se va a eliminar
	 * @throws IWDaoException
	 */
	public void eliminar(Usuario usuario) throws IWDaoException;
	/**
	 * Definici�n del m�todo que permite verificar y validar el acceso de un usuario al sistema a trav�s de su nombre y su contrase�a
	 * @param nombre nombre o alias de lusuario en el sistema
	 * @param pwd contrase�a del usuario
	 * @return cadena de caract�res informando si el inicio de sesi�n es correcto o no
	 * @throws IWDaoException
	 */
	public String login (String nombre, String pwd) throws IWDaoException;
}
