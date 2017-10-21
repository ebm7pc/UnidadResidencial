package co.udea.iw.dao;

import java.util.List;

import co.udea.iw.dto.Cliente;
import co.udea.iw.dto.Vehiculo;
import co.udea.iw.exception.IWDaoException;

public interface VehiculoDAO {
	public Vehiculo insertar(Vehiculo vehiculo) throws IWDaoException;
	public void eliminar(Vehiculo vehiculo) throws IWDaoException;
	public List <Vehiculo> obtenerByCliente(Integer idCliente) throws IWDaoException;
	public Cliente obtenerById(Integer placa) throws IWDaoException;
}
