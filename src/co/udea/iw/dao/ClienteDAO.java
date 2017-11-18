package co.udea.iw.dao;

import java.util.List;

import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;
/**
 * 
 * @author Eduardo B , Yesid M
 * Interfaz que contiene la estructura de los metos a implementar en la clase ClienteDAOHibernate
 */
public interface ClienteDAO {
	/**
	 * Definici�n del m�todo que permite insertar un nuevo cliente
	 * @param cliente objeto de tipo cliente
	 * @return cliente con datos a ser insertados
	 * @throws IWDaoException
	 */
	public Cliente insertar(Cliente cliente) throws IWDaoException;
	/**
	 * Definici�n del m�todo que permite modificar los datos de un cliente
	 * @param cliente objeto de tipo cliente
	 * @return cliente con datos a ser modificados
	 * @throws IWDaoException
	 */
	public Cliente modificar(Cliente cliente) throws IWDaoException;
	/**
	 * Definici�n del m�todo que permite eliminar a un cliente existente
	 * @param cliente objeto de tipo cliente
	 * @throws IWDaoException
	 */
	public void eliminar(Cliente cliente) throws IWDaoException;
	/**
	 * Definici�n del m�todo que obtiene la lista de todos los clientes existenes en el sistema
	 * @return lista completa de todos los cliente del sistema
	 * @throws IWDaoException
	 */
	public List <Cliente> obtener() throws IWDaoException;
	/**
	 * Definici�n del m�todo que obtiene la lista de clientes por tipo Residente o por tipo Residente
	 * @param tipo tipo de cliente Residenteo Visitante
	 * @return lista de los clientes de tipo Residente o de tipo Visitante
	 * @throws IWDaoException
	 */
	public List<Cliente> obtenerByTipo(String tipo) throws IWDaoException;
	/**
	 * Definici�n del m�todo que obtiene un cliente determinado por su n�mero de ficho
	 * @param ficho n�mero de ficho de cliente
	 * @return objeto de tipo cliente con sus datos correspondientes
	 * @throws IWDaoException
	 */
	public Cliente  obtener(Integer ficho) throws IWDaoException;
	/**
	 * Definici�n del m�todo que comprueba el ficho de un cliente para su acceso
	 * @param ficho
	 * @return
	 * @throws IWDaoException
	 */
	public String comprobarAcceso(Integer ficho) throws IWDaoException; 
}
