package co.udea.iw.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.udea.iw.dao.AccesoDAO;
import co.udea.iw.dao.ClienteDAO;
import co.udea.iw.dto.Acceso;
import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;
import co.udea.iw.exception.IWServiceException;
import co.udea.iw.util.validations.Validaciones;

/**
 * 
 * @author Eduardo Bedoya, Yesid Montoya
 *Clase para implementar los servicios del m�dulo de accesos
 */
public class AccesoService {

	@Autowired
	AccesoDAO accesoDAO;
	ClienteDAO clienteDAO;
	/**
	 * getter del AccesoDAO
	 * @return objeto de tipo AccesoDAO
	 */
	public AccesoDAO getAccesoDAO() {
		return accesoDAO;
	}
	/**
	 * setter del AccesoDAO
	 * @param accesoDAO objeto de tipo AccesoDAO 
	 */
	public void setAccesoDAO(AccesoDAO accesoDAO) {
		this.accesoDAO = accesoDAO;
	}
	/**
	 * getter del tipo ClienteDAO
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
	 * M�todo para guardar un acceso
	 * @param id identificador del acceso
	 * @param clienteAccede identificador del cliente que realiz� el acceso
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public void guardarAcceso(Integer id, Integer clienteAccede) throws  IWDaoException, IWServiceException{
		Acceso acceso =null;
		Cliente cliente=null;
		if(Validaciones.isTextoVacio(String.valueOf(id))) {
			throw new IWServiceException("El id no puede ser vac�o");
		}
		cliente=clienteDAO.obtener(clienteAccede);
		if(cliente==null) {
			throw new IWServiceException("El usuario no existe");
		}
		acceso= new Acceso();
		acceso.setId(id);
		acceso.setIdCliente(cliente);
		acceso.setFechaAcceso(new Date());
		accesoDAO.insertar(acceso);
	}
	/**
	 * M�todo para obtener la lista de todos los accesos
	 * @return lista de todos los accesos
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public List<Acceso> obtener()throws IWDaoException, IWServiceException{
		return accesoDAO.obtener();
	}
	/**
	 * M�todo para para obtener una lista de accesos filtrada por tipo de cliente
	 * @param tipo tipo de cliente
	 * @return lista de accesos por tipo de cliente
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public List<Acceso> obtenerPorTipoC(String tipo)throws IWDaoException, IWServiceException{
		if(Validaciones.isTextoVacio(tipo)){
			throw new IWServiceException("El tipo de cliente no puede ser vac�o");
		}
		return accesoDAO.obtenerByTipoCliente(tipo);
	}
	/**
	 * M�todo para obtener la lista de accesos de un cliente determinado
	 * @param ficho del cliente
	 * @return lista de accesos de un cliente
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public List<Acceso> obtenerPorCliente(Integer ficho)throws IWDaoException, IWServiceException{
		if(Validaciones.isTextoVacio(String.valueOf(ficho))){
			throw new IWServiceException("El ficho de cliente no puede ser vac�o");
		}
		return accesoDAO.obtenerByIdCliente(ficho);
	}
	/**
	 * M�todo para obtener los accesos en un rango de fechas
	 * @param fechaInicio fecha inicial
	 * @param fechaFinal fecha final
	 * @return lista de accesos en un rango de fechas
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public List<Acceso> obtenerPorFecha(Date fechaInicio, Date fechaFinal)throws IWDaoException, IWServiceException{
		if(fechaInicio==null || fechaFinal==null){
			throw new IWServiceException("Las fechas no pueden ser vac�as");
		}
		return accesoDAO.obtenerByFecha(fechaInicio, fechaFinal);
	}
}
