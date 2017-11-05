package co.udea.iw.dao;

import java.util.Date;
import java.util.List;

import co.udea.iw.dto.Acceso;
import co.udea.iw.exception.IWDaoException;
/**
 * 
 * @author Eduardo B , Yesid M
 * Interfaz que contiene la estructura de los métodos a implementar en la clase AccesoDAOHibernate
 */
public interface AccesoDAO {
	/**
	 * Definición del método para insertar un nuevo acceso
	 * @param acceso objeto de tipo Acceso
	 * @return acceso con datos a ser insertados
	 * @throws IWDaoException
	 */
	public Acceso insertar(Acceso acceso) throws IWDaoException;
	/**
	 * Definición del método que retorna toda la lista de accesos existentes
	 * @return Lista de todos los acceos existentes
	 * @throws IWDaoException
	 */
	public List <Acceso> obtener() throws IWDaoException;
	/**
	 * Definición del método que retorna la lista de accesos realizados por un mismo cliente
	 * @param ficho número del ficho que se le da al cliente
	 * @return lista de acceso del ciente seleccionado
	 * @throws IWDaoException
	 */
	public List <Acceso> obtenerByIdCliente(Integer ficho) throws IWDaoException;
	/**
	 * Definición del método que retorna la lista de accesos en un rango de fechas determinado
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return ista de accesos realizados en un rango de fechas
	 * @throws IWDaoException
	 */
	public List <Acceso> obtenerByFecha(Date fechaInicial, Date fechaFinal) throws IWDaoException;
	/**
	 * Definición del método que retorna la lista de accesos realizados por los cliente de tipo Residente o de tipo Visitante
	 * @param tipo clase de cliente que Accedió: Residente o Visitante
	 * @return ista de accesos realizados por Residentes o por Visitantes
	 * @throws IWDaoException
	 */
	public List <Acceso> obtenerByTipoCliente(String tipo) throws IWDaoException;
}
