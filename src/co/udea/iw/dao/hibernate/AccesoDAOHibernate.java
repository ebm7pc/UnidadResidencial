package co.udea.iw.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.udea.iw.dao.AccesoDAO;
import co.udea.iw.dto.Acceso;
import co.udea.iw.exception.IWDaoException;

public class AccesoDAOHibernate extends HibernateDaoSupport implements AccesoDAO {

	@Override
	public Acceso insertar(Acceso acceso) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Acceso acceso) throws IWDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Acceso> obtener() throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Acceso> obtenerByIdUsuario(Integer IdUsuario) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
