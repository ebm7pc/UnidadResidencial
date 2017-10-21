package co.udea.iw.dao;

import java.util.List;
import co.udea.iw.dto.Visitante;
import co.udea.iw.exception.IWDaoException;

public interface VisitanteDAO {
	public Visitante insertar(Visitante visitante) throws IWDaoException;
	public Visitante modificar(Visitante visitante) throws IWDaoException;
	public void eliminar(Visitante visitante) throws IWDaoException;
	public List <Visitante> obtener() throws IWDaoException;
	public Visitante obtener(String cedula) throws IWDaoException;
}
