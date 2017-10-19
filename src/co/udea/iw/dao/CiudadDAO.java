package co.udea.iw.dao;

import java.util.List;

import co.udea.iw.dto.Ciudad;
import co.udea.iw.exception.IWDaoException;

/**
 * Interface que define los m�todos que va a proveer el dao de ciudad
 * @author Eduardo Bedoya M
 *
 */
public interface CiudadDAO {
	/**
	 * Entrega la lista de ciudades existentes en a base de datos
	 * @return lista ciudades
	 * @throws IWDaoException
	 */
	public List<Ciudad> obtener() throws IWDaoException;
	/**
	 * Entrega os datos de una ciudad dado su c�digo
	 * @param codigo c�digo de la ciudad a consultar
	 * @return Una instancia de os datos de la ciudad obtenida, si
	 * no existe una ciudad con el c�digo dado retorna null
	 * @throws IWDaoException
	 */
	public Ciudad obtener(Integer codigo) throws IWDaoException;

}
