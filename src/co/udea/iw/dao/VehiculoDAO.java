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
	public Vehiculo insertar(Vehiculo vehiculo) throws IWDaoException;
	public void eliminar(Vehiculo vehiculo) throws IWDaoException;
	public List <Vehiculo> obtenerByCliente(Integer idCliente) throws IWDaoException;
	public Cliente obtenerById(String placa) throws IWDaoException;
}
