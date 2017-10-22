package co.udea.iw.dao;

import java.util.Date;
import java.util.List;

import co.udea.iw.dto.Acceso;
import co.udea.iw.exception.IWDaoException;
/**
 * 
 * @author Eduardo B , Yesid M
 * Interfaz que contiene la estructura de los metos a implementar en la clase AccesoDAOHibernate
 */
public interface AccesoDAO {
	public Acceso insertar(Acceso acceso) throws IWDaoException;
	public List <Acceso> obtener() throws IWDaoException;
	public List <Acceso> obtenerByIdCliente(Integer ficho) throws IWDaoException;
	public List <Acceso> obtenerByFecha(Date fechaInicial, Date fechaFinal) throws IWDaoException;
	public List <Acceso> obtenerByTipoCliente(String tipo) throws IWDaoException;
	
}
