package co.udea.iw.dao;

import java.util.List;

import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;

public interface ClienteDAO {
	public Cliente insertar(Cliente residente) throws IWDaoException;
	public Cliente modificar(Cliente residente) throws IWDaoException;
	public void eliminar(Cliente residente) throws IWDaoException;
	public List <Cliente> obtener() throws IWDaoException;
	public List<Cliente> obtenerByTipo(String tipo) throws IWDaoException;
	public Cliente obtener(Integer ficho) throws IWDaoException;
}
