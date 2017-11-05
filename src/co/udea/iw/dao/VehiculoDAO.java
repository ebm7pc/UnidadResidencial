package co.udea.iw.dao;

import java.util.List;

import co.udea.iw.dto.Cliente;
import co.udea.iw.dto.Vehiculo;
import co.udea.iw.exception.IWDaoException;
/**
 * 
 * @author Eduardo B , Yesid M
 * Interfaz que contiene la estructura de los metos a implementar en la clase VehiculoDAOHibernate
 */
public interface VehiculoDAO {
	/**
	 * Definición del método que permite instertar un nuevo vehículo
	 * @param vehiculo objeto de tipo Vehiculo
	 * @return vehículo con sus datos a ser insertados
	 * @throws IWDaoException
	 */
	public Vehiculo insertar(Vehiculo vehiculo) throws IWDaoException;
	/**
	 * Definición del método que permite eliminar un vehículo de sistema
	 * @param vehiculo vehículo a ser eliminado
	 * @throws IWDaoException
	 */
	public void eliminar(Vehiculo vehiculo) throws IWDaoException;
	/**
	 * Definición del método para obtener una lista de vehículos de un mismo cliente
	 * @param idCliente número de ficho del cliente que registra la lista de vehículos
	 * @return Lista de vehiculos de un cliente
	 * @throws IWDaoException
	 */
	public List <Vehiculo> obtenerByCliente(Integer idCliente) throws IWDaoException;
	/**
	 * Definición del método para obtener a un cliente que registro un vehículo determinado
	 * @param placa número de la placa del vehículo registrado por el cliente
	 * @return Cliente que registró el vehículo
	 * @throws IWDaoException
	 */
	public Cliente obtenerById(String placa) throws IWDaoException;
	/**
	 * Definición del método que permite obtener un vehículo determinado y sus datos
	 * @param placa placa del vehículo
	 * @return objeto de tipo vehículo con sus datos respectivos
	 * @throws IWDaoException
	 */
	public Vehiculo obtener(String placa) throws IWDaoException;
}