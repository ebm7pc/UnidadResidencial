package co.udea.iw.dao;

import java.util.List;

import co.udea.iw.dto.Residente;
import co.udea.iw.exception.IWDaoException;

public interface ResidenteDAO {
	public Residente insertar(Residente residente) throws IWDaoException;
	public Residente modificar(Residente residente) throws IWDaoException;
	public void eliminar(Residente residente) throws IWDaoException;
	public List <Residente> obtener() throws IWDaoException;
	public Residente obtener(String cedula) throws IWDaoException;
}
