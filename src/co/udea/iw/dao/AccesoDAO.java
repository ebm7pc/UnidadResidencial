package co.udea.iw.dao;

import java.util.List;

import co.udea.iw.dto.Acceso;
import co.udea.iw.exception.IWDaoException;

public interface AccesoDAO {
	public Acceso insertar(Acceso acceso) throws IWDaoException;
	public void eliminar(Acceso acceso) throws IWDaoException;
	public List <Acceso> obtener() throws IWDaoException;
	public List <Acceso> obtenerByIdUsuario(Integer IdUsuario) throws IWDaoException;

}
