package co.udea.iw.service;

import java.util.Date;


import co.udea.iw.dao.UsuarioDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.dto.Usuario;
import co.udea.iw.exception.IWDaoException;
import co.udea.iw.exception.IWServiceException;
import co.udea.iw.util.validations.Validaciones;

public class UsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
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

	
	public String iniciarSeccion(String nombreUsuario, String password) {
		
		if(Validaciones.isTextoVacio(nombreUsuario)){
			throw new IWServiceException("El nombre de usuario no puede ser vacío");
		}
		
		if(Validaciones.isTextoVacio(password)){
			throw new IWServiceException("La contraseña del usuario no puede ser vacía");
		}
		
		return usuarioDAO.login(nombreUsuario, password);
		
	}
	
    public Usuario modificarUsuario(String nombreUsuario, String password) {
		
		if(Validaciones.isTextoVacio(nombreUsuario)){
			throw new IWServiceException("El nombre de usuario no puede ser vacío");
		}
		
		if(Validaciones.isTextoVacio(password)){
			throw new IWServiceException("La contraseña del usuario no puede ser vacía");
		}
		
		return usuarioDAO.modificar(nombreUsuario, password);
		
	}
    
public Usuario obtenerUsuario(String nombreUsuario) {
		
		if(Validaciones.isTextoVacio(nombreUsuario)){
			throw new IWServiceException("El nombre de usuario no puede ser vacío");
		}		
		
		return usuarioDAO.obtener(nombreUsuario);
		
	}


}
