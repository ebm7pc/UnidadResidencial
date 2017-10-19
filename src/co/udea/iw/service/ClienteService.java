package co.udea.iw.service;

import java.rmi.ServerException;
import java.util.Date;
import java.util.List;

import co.udea.iw.dao.ClienteDAO;
import co.udea.iw.dao.UsuarioDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.dto.Usuario;
import co.udea.iw.exception.IWDaoException;
import co.udea.iw.exception.IWServiceException;
import co.udea.iw.util.validations.Validaciones;

public class ClienteService {
	private ClienteDAO clienteDAO;
	private UsuarioDAO usuarioDAO;
	
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public void guardarCliente(String cedula, String nombres, String apellidos, 
			String correoElectronico, String usuarioCrea) throws IWDaoException, IWServiceException{
		Cliente cliente = null;
		if(Validaciones.isTextoVacio(cedula)) {
			throw new IWServiceException("La cédula de cliente no puede ser nula, ni una cadena de caracteres vacía");			
		}
		if(Validaciones.isTextoVacio(nombres)) {
			throw new IWServiceException("El nombre de cliente no pueden ser nulo, ni una cadena de caracteres vacía");			
		}
		if(Validaciones.isTextoVacio(apellidos)) {
			throw new IWServiceException("El apellido de cliente no pueden ser nulo, ni una cadena de caracteres vacía");			
		}
		if(Validaciones.isTextoVacio(correoElectronico)) {
			throw new IWServiceException("El E-mail de cliente no pueden ser nulo, ni una cadena de caracteres vacía");			
		}
		if(!Validaciones.isEmail(correoElectronico)) {
			throw new IWServiceException("El correo electrónico del cliente debe tener un formato válido");			
		}
		if(Validaciones.isTextoVacio(usuarioCrea)) {
			throw new IWServiceException("El usuario que crea el cliente no pueden ser nulo, ni una cadena de caracteres vacía");			
		}
		Usuario usuario = usuarioDAO.obtener(usuarioCrea);
//		if (usuario == null) {
//			throw new IWServiceException("El usuario que crea el cliente debe ser un usuario del sistema");
//		}
		cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setCorreoElectronico(correoElectronico);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		//cliente.setEliminado(Boolean.FALSE);
		clienteDAO.insertar(cliente);
	}
	
	public List<Cliente> obtener() throws IWDaoException{
		return clienteDAO.obtener();
	}
	
	public Cliente obtener(String cedula) throws IWDaoException, IWServiceException{
		if(cedula==null && "".equals(cedula)) {
			throw new IWServiceException("La cédula de cliente no puede ser nula, ni una cadena de caracteres vacía");
		}
		return clienteDAO.obtener(cedula);
	}

}
