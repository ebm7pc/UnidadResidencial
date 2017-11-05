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
	 * Definici�n del m�todo que permite instertar un nuevo veh�culo
	 * @param vehiculo objeto de tipo Vehiculo
	 * @return veh�culo con sus datos a ser insertados
	 * @throws IWDaoException
	 */
	public Vehiculo insertar(Vehiculo vehiculo) throws IWDaoException;
	/**
	 * Definici�n del m�todo que permite eliminar un veh�culo de sistema
	 * @param vehiculo veh�culo a ser eliminado
	 * @throws IWDaoException
	 */
	public void eliminar(Vehiculo vehiculo) throws IWDaoException;
	/**
	 * Definici�n del m�todo para obtener una lista de veh�culos de un mismo cliente
	 * @param idCliente n�mero de ficho del cliente que registra la lista de veh�culos
	 * @return Lista de vehiculos de un cliente
	 * @throws IWDaoException
	 */
	public List <Vehiculo> obtenerByCliente(Integer idCliente) throws IWDaoException;
	/**
	 * Definici�n del m�todo para obtener a un cliente que registro un veh�culo determinado
	 * @param placa n�mero de la placa del veh�culo registrado por el cliente
	 * @return Cliente que registr� el veh�culo
	 * @throws IWDaoException
	 */
	public Cliente obtenerById(String placa) throws IWDaoException;
	/**
	 * Definici�n del m�todo que permite obtener un veh�culo determinado y sus datos
	 * @param placa placa del veh�culo
	 * @return objeto de tipo veh�culo con sus datos respectivos
	 * @throws IWDaoException
	 */
	public Vehiculo obtener(String placa) throws IWDaoException;
}