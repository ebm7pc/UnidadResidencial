package co.udea.iw.dao;

import java.util.List;

import co.udea.iw.dto.Vehiculo;
import co.udea.iw.dto.Visitante;
import co.udea.iw.exception.IWDaoException;

public interface VehiculoDAO {
	public Vehiculo insertar(Vehiculo vehiculo) throws IWDaoException;
	//public Vehiculo modificar(Vehiculo vehiculo) throws IWDaoException;
	public void eliminar(Vehiculo vehiculo) throws IWDaoException;
	public List <Vehiculo> obtener(Integer idCliente) throws IWDaoException;
	public Vehiculo obtenerById(Integer id) throws IWDaoException;
}
