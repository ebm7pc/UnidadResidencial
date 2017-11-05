package co.udea.iw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.udea.iw.dao.ClienteDAO;
import co.udea.iw.dao.VehiculoDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.dto.Vehiculo;
import co.udea.iw.exception.IWDaoException;
import co.udea.iw.exception.IWServiceException;
import co.udea.iw.util.validations.Validaciones;
/**
 * 
 * @author Eduardo Bedoya, Yesid Montoya
 *Clase para implementar los servicios del módulo de vehículo
 */
public class VehiculoService {
	@Autowired
	VehiculoDAO vehiculoDAO;
	ClienteDAO clienteDAO;
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
	 * getter del VehiculoDAO
	 * @return objeto de tipo VehiculoDAO
	 */
	public VehiculoDAO getVehiculoDAO() {
		return vehiculoDAO;
	}
	/**
	 * setter del VehiculoDAO
	 * @param vehiculoDAO objeto de tipo VehiculoDAO
	 */
	public void setVehiculoDAO(VehiculoDAO vehiculoDAO) {
		this.vehiculoDAO = vehiculoDAO;
	}
	/**
	 * Método para guardar un vehículo
	 * @param placa placa del vehículo
	 * @param marca marca del vehículo
	 * @param fichoCliente número de ficho del cliente asociado a vehículo
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public void guardarVehiculo(String placa, String marca, Integer fichoCliente) throws  IWDaoException, IWServiceException{
		Vehiculo vehiculo =null;
		Cliente cliente=null;
		if(Validaciones.isTextoVacio(placa)) {
			throw new IWServiceException("La placa del vehiculo no puede ser vacía");
		}
		if(Validaciones.isTextoVacio(marca)) {
			throw new IWServiceException("La marca del vehiculo no puede ser vacía");
		}
		cliente=clienteDAO.obtener(fichoCliente);
		if(cliente == null ) {
			throw new IWServiceException("El vehiculo debe tener un propietario");
		}  
		vehiculo= new Vehiculo();
		vehiculo.setPlaca(placa);
		vehiculo.setMarca(marca);
		vehiculo.setIdCliente(cliente);
		vehiculoDAO.insertar(vehiculo);
	}
	/**
	 * Método para eliminar un vehículo
	 * @param placa placa de vehículo
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public void eliminarVehiculo(String placa) throws IWDaoException, IWServiceException {
		Vehiculo vehiculo =null;
		if(Validaciones.isTextoVacio(placa)){
			throw new IWServiceException("La placa del vehiculo no puede ser vacío");
		}
		vehiculo=vehiculoDAO.obtener(placa);
		if(vehiculo==null) {
			throw new IWServiceException("No existe un vehiculo con esta placa");
		}
		vehiculoDAO.eliminar(vehiculo);
	}
	/**
	 * Método para obtener el cliente asociado a un vehículo
	 * @param placa placa del vehículo
	 * @return cliente asociado al vehículo
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public Cliente obtenerDueño(String placa) throws IWDaoException, IWServiceException {
		if(Validaciones.isTextoVacio(placa)){
			throw new IWServiceException("La placa del vehiculo no puede ser vacío");
		}
		return vehiculoDAO.obtenerById(placa);
	}
	/**
	 * Método para obtener la ista de vehículos de un cliente
	 * @param idCliente número del ficho asociado al cliente
	 * @return lista de vehículos asociados a un cliente
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public List<Vehiculo> obtenerVehiculos(Integer idCliente) throws IWDaoException, IWServiceException {
		if(Validaciones.isTextoVacio(String.valueOf(idCliente))){
			throw new IWServiceException("La identificacion del cliente no puede ser vacía");
		}
		return vehiculoDAO.obtenerByCliente(idCliente);
	}
}
