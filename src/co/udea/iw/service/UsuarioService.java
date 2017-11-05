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
 *Clase para implementar los servicios del módulo de Usuario
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
	 * Método para guardar un usuario
	 * @param nombreUsuario nombre del usuario
	 * @param password contraseña del usuario
	 * @param tipoUsuario tipo de usuario: Administrador o Regular
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public void guardarUsuario(String nombreUsuario, String password, String tipoUsuario) throws  IWDaoException, IWServiceException{	
		Usuario usuario =null; 		
		if(Validaciones.isTextoVacio(nombreUsuario)) {
			throw new IWServiceException("El nombre de usuario no puede ser vacío");
		}		
		if(Validaciones.isTextoVacio(password)) {
			throw new IWServiceException("La contraseña del usuario no puede ser vacía");
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
	 * Método para eliminar un usuario
	 * @param nombreUsuario nombre del usuario a eliminar
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public void eliminarUsuario(String nombreUsuario) throws IWDaoException, IWServiceException {
		Usuario usuario =null;
		if(Validaciones.isTextoVacio(nombreUsuario)){
			throw new IWServiceException("El nombre de usuario no puede ser vacío");
		}
		usuario=usuarioDAO.obtener(nombreUsuario);
		if(usuario==null) {
			throw new IWServiceException("No existe un usuario con este nombre");
		}
		usuarioDAO.eliminar(usuario);
	}
	/**
	 * Método para verificar un inicio de sesión correcto o no
	 * @param nombreUsuario nombre del usuario que inicia sesión
	 * @param password contraseña del usuari oque inicia sesión
	 * @return cadena de caractéres con mensaje si inició sesión correctamente o no
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public String iniciarSeccion(String nombreUsuario, String password) throws IWDaoException, IWServiceException {		
		if(Validaciones.isTextoVacio(nombreUsuario)){
			throw new IWServiceException("El nombre de usuario no puede ser vacío");
		}
		if(Validaciones.isTextoVacio(password)){
			throw new IWServiceException("La contraseña del usuario no puede ser vacía");
		}
		return usuarioDAO.login(nombreUsuario, password);
	}
	/**
	 * Método para modificar a contraseña de un usuario
	 * @param nombreUsuario nombre de usuario
	 * @param password contraseña nueva
	 * @return objeto de tipo Usuario
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
    public Usuario modificarUsuario(String nombreUsuario, String password) throws IWDaoException, IWServiceException {
		if(Validaciones.isTextoVacio(nombreUsuario)){
			throw new IWServiceException("El nombre de usuario no puede ser vacío");
		}	
		if(Validaciones.isTextoVacio(password)){
			throw new IWServiceException("La contraseña del usuario no puede ser vacía");
		}
		return usuarioDAO.modificar(nombreUsuario, password);
	}
    /**
     * Método para obtenerun usuario por su nombre
     * @param nombreUsuario nombre del usuario
     * @return objeto de tipo Usuario
     * @throws IWDaoException
     * @throws IWServiceException
     */
    public Usuario obtenerUsuario(String nombreUsuario) throws IWDaoException, IWServiceException {
		if(Validaciones.isTextoVacio(nombreUsuario)){
			throw new IWServiceException("El nombre de usuario no puede ser vacío");
		}		
		return usuarioDAO.obtener(nombreUsuario);
	}
}
