package co.udea.iw.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.udea.iw.dao.ClienteDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;
import co.udea.iw.exception.IWServiceException;
import co.udea.iw.util.validations.Validaciones;

/**
 * 
 * @author Eduardo Bedoya, Yesid montoya
 *Clase para implementar los servicios del m�dulo de Cliente
 */
public class ClienteService {

	@Autowired
	private ClienteDAO clienteDAO;

	/**
	 * getter del ClienteDAO
	 * @return objeto de tipo ClienteDAO
	 */
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	/**
	 * setter del ClienteDAO
	 * @param clienteDAO objeto de tipo ClienteDAO
	 */
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	/**
	 * M�todo para guardar un cliente
	 * @param ficho ficho del cliente
	 * @param tipo tipo de cliente
	 * @param nombre nombre de cliente
	 * @param apellido apellido del cliente
	 * @param identificacion c�dula del cliente
	 * @param apartamento n�mero de partamento donde vive el cliente si es Residente o del apartamento al que se dirige si es visitante
	 * @param telefono teefono del cliente
	 * @param celular celular del cliente
	 * @param correo correo electr�nico del cliente
	 * @param tiene_vehiculo booleano para determinar si el cliente tiene veh�culo(s) o no
	 * @param responsable persona responsable de recibir al cliente si es un Visitante
	 * @param fecha_salida fecha de expiraci�n del permiso de acceso si el cliente es un Visitante
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public void guardarCliente(Integer ficho, String tipo, String nombre, String apellido, Long identificacion,
			String apartamento, Long telefono, Long celular, String correo, boolean tiene_vehiculo, String responsable,
			Date fecha_salida) throws IWDaoException, IWServiceException {
		Cliente cliente = null;
		if (Validaciones.isTextoVacio(String.valueOf(ficho))) {
			throw new IWServiceException("El ficho no puede ser nulo ni vacio ");
		}
		if (Validaciones.isTextoVacio(tipo)) {
			throw new IWServiceException("El tipo de usuario debe estar definido ");
		}
		if (Validaciones.isTextoVacio(nombre)) {
			throw new IWServiceException("El nombre de usuario no puede ser vacio ");
		}
		if (Validaciones.isTextoVacio(apellido)) {
			throw new IWServiceException("El apellido del cliente no puede estar vacio ");
		}
		if (Validaciones.isTextoVacio(String.valueOf(identificacion))) {
			throw new IWServiceException("La identificacion del usuario no puede estar vacia ");
		}
		if (Validaciones.isTextoVacio(String.valueOf(apartamento))) {
			throw new IWServiceException("El campo de apartamento del usuario no puede estar vacio ");
		}
		if (Validaciones.isTextoVacio(String.valueOf(String.valueOf(tiene_vehiculo)))) {
			throw new IWServiceException("La opci�n de veh�culo del usuario no puede estar vacia ");
		}
		if (!Validaciones.isTextoVacio(correo)) {
			if (!Validaciones.isEmail(correo)) {
				throw new IWServiceException("El correo electronico del cliente debe ser valido");
			}
		}
		cliente = new Cliente();
		cliente.setFicho(ficho);
		cliente.setTipo(tipo);
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setIdentificacion(identificacion);
		cliente.setApartamento(apartamento);
		cliente.setTelefono(telefono);
		cliente.setCelular(celular);
		cliente.setCorreo(correo);
		cliente.setTieneVehiculo(tiene_vehiculo);
		cliente.setResponsable(responsable);
		cliente.setFechaSalida(fecha_salida);
		cliente.setFechaRegistro(new Date());
		clienteDAO.insertar(cliente);
	}
	/**
	 * M�todo para obtener la lista de todos los clientes
	 * @return lista de todos los clientes
	 * @throws IWDaoException
	 */
	public List<Cliente> obtener() throws IWDaoException {
		return clienteDAO.obtener();
	}
	/**
	 * M�todo para obtener la lista de clientes por tipo
	 * @param tipo tipo de cliente: Residente o Visitante
	 * @return lista de Clientes por Residentes o por Visitantes
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public List<Cliente> obtenerPorTipo(String tipo) throws IWDaoException, IWServiceException {
		if (Validaciones.isTextoVacio(tipo)) {
			throw new IWServiceException("El tipo de cliente no puede ser vac�o");
		}
		return clienteDAO.obtenerByTipo(tipo);
	}
	/**
	 * M�todo para obtener un cliente determinado
	 * @param ficho n�mero del ficho asociado al cliente
	 * @return cliente con el ficho asociado
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public Cliente obtener(Integer ficho) throws IWDaoException, IWServiceException {
		if (ficho == null) {
			throw new IWServiceException("El ficho del cliente no puede esatr vacio");
		}
		return clienteDAO.obtener(ficho);
	}
	/**
	 * M�todo para modificar un cliente
	 * @param ficho n�mero del ficho asociado al cliente
	 * @param apartamento apartamento del cliente
	 * @param telefono telefono del cliente
	 * @param celular celular del cliente
	 * @param correo correo electr�nico del cliente
	 * @param tiene_vehiculo booleano para deteminar si tiene veh�culo o no
	 * @param fecha_salida fecha de expiracion de permiso de acceso para cientes de tipo Visitante
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public void modificarCliente(Integer ficho, String apartamento, Long telefono, Long celular, String correo,
			boolean tiene_vehiculo, Date fecha_salida) throws IWDaoException, IWServiceException {
		Cliente cliente = null;
		if (Validaciones.isTextoVacio(String.valueOf(ficho))) {
			throw new IWServiceException("El ficho no puede ser nulo ni vacio ");
		}
		if (Validaciones.isTextoVacio(String.valueOf(apartamento))) {
			throw new IWServiceException("El campo de apartamento del usuario no puede estar vacio ");
		}
		if (Validaciones.isTextoVacio(String.valueOf(String.valueOf(tiene_vehiculo)))) {
			throw new IWServiceException("La opci�n de veh�culo del usuario no puede estar vacia ");
		}
		if (!Validaciones.isTextoVacio(correo)) {
			if (!Validaciones.isEmail(correo)) {
				throw new IWServiceException("El correo electronico del cliente debe ser valido");
			}
		}
		cliente = clienteDAO.obtener(ficho);
		if (cliente == null) {
			throw new IWServiceException("No existe un cliente con este n�mero de ficho");
		}
		cliente.setFicho(ficho);
		cliente.setApartamento(apartamento);
		cliente.setTelefono(telefono);
		cliente.setCelular(celular);
		cliente.setCorreo(correo);
		cliente.setTieneVehiculo(tiene_vehiculo);
		cliente.setFechaSalida(fecha_salida);
		clienteDAO.modificar(cliente);
	}
	/**
	 * M�todo para eliminar un cliente
	 * @param ficho n�mero de ficho asiciado al cliente que se va a eliminar
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public void eliminarCliente(Integer ficho) throws IWDaoException, IWServiceException {
		Cliente cliente = null;
		if (Validaciones.isTextoVacio(String.valueOf(ficho))) {
			throw new IWServiceException("El n�mero de ficho no puede ser vac�o");
		}
		cliente = clienteDAO.obtener(ficho);
		if (cliente == null) {
			throw new IWServiceException("No existe un cliente con este n�mero de ficho");
		}
		clienteDAO.eliminar(cliente);
	}
	
	public String comprobarAcceso(Integer ficho) throws IWDaoException, IWServiceException {
		if (ficho == null) {
			throw new IWServiceException("El ficho del cliente no puede esatar vacio");
		}
		return clienteDAO.comprobarAcceso(ficho);
	}
}
