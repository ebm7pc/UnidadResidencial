package co.udea.iw.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import co.udea.iw.dao.UsuarioDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.dto.Usuario;
import co.udea.iw.exception.IWDaoException;
import co.udea.iw.exception.IWServiceException;
import co.udea.iw.util.validations.Validaciones;

/**
 * 
 * @author Eduardo Bedoya, Yesid Montoya
 *Clase para implementar los servicios del m�dulo de Usuario
 */
public class UsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	/**
	 * getter del UsuarioDAO
	 * @return objeto de tipo UsuarioDAO
	 */
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	/**
	 * setter del UsuarioDAO
	 * @param usuarioDAO objeto de tipo UsuarioDAO
	 */
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	/**
	 * M�todo para guardar un usuario
	 * @param nombreUsuario nombre del usuario
	 * @param password contrase�a del usuario
	 * @param tipoUsuario tipo de usuario: Administrador o Regular
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public void guardarUsuario(String nombreUsuario, String password, String tipoUsuario) throws  IWDaoException, IWServiceException{	
		Usuario usuario =null; 		
		if(Validaciones.isTextoVacio(nombreUsuario)) {
			throw new IWServiceException("El nombre de usuario no puede ser vac�o");
		}		
		if(Validaciones.isTextoVacio(password)) {
			throw new IWServiceException("La contrase�a del usuario no puede ser vac�a");
		}		
		if(Validaciones.isTextoVacio(tipoUsuario)) {
			throw new IWServiceException("El usuario debe tener un tipo definido");
		}  	
		usuario= new Usuario();		
		usuario.setNombreUsuario(nombreUsuario);;
		usuario.setPassword(password);
		usuario.setTipoUsuario(tipoUsuario);
		usuarioDAO.insertar(usuario);
	}
	/**
	 * M�todo para eliminar un usuario
	 * @param nombreUsuario nombre del usuario a eliminar
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public void eliminarUsuario(String nombreUsuario) throws IWDaoException, IWServiceException {
		Usuario usuario =null;
		if(Validaciones.isTextoVacio(nombreUsuario)){
			throw new IWServiceException("El nombre de usuario no puede ser vac�o");
		}
		usuario=usuarioDAO.obtener(nombreUsuario);
		if(usuario==null) {
			throw new IWServiceException("No existe un usuario con este nombre");
		}
		usuarioDAO.eliminar(usuario);
	}
	/**
	 * M�todo para verificar un inicio de sesi�n correcto o no
	 * @param nombreUsuario nombre del usuario que inicia sesi�n
	 * @param password contrase�a del usuari oque inicia sesi�n
	 * @return cadena de caract�res con mensaje si inici� sesi�n correctamente o no
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public String iniciarSeccion(String nombreUsuario, String password) throws IWDaoException, IWServiceException {		
		if(Validaciones.isTextoVacio(nombreUsuario)){
			throw new IWServiceException("El nombre de usuario no puede ser vac�o");
		}
		if(Validaciones.isTextoVacio(password)){
			throw new IWServiceException("La contrase�a del usuario no puede ser vac�a");
		}
		return usuarioDAO.login(nombreUsuario, password);
	}
	/**
	 * M�todo para modificar a contrase�a de un usuario
	 * @param nombreUsuario nombre de usuario
	 * @param password contrase�a nueva
	 * @return objeto de tipo Usuario
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
    public Usuario modificarUsuario(String nombreUsuario, String password) throws IWDaoException, IWServiceException {
		if(Validaciones.isTextoVacio(nombreUsuario)){
			throw new IWServiceException("El nombre de usuario no puede ser vac�o");
		}	
		if(Validaciones.isTextoVacio(password)){
			throw new IWServiceException("La contrase�a del usuario no puede ser vac�a");
		}
		return usuarioDAO.modificar(nombreUsuario, password);
	}
    /**
     * M�todo para obtenerun usuario por su nombre
     * @param nombreUsuario nombre del usuario
     * @return objeto de tipo Usuario
     * @throws IWDaoException
     * @throws IWServiceException
     */
    public Usuario obtenerUsuario(String nombreUsuario) throws IWDaoException, IWServiceException {
		if(Validaciones.isTextoVacio(nombreUsuario)){
			throw new IWServiceException("El nombre de usuario no puede ser vac�o");
		}		
		return usuarioDAO.obtener(nombreUsuario);
	}
}
