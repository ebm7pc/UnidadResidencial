package co.udea.iw.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.udea.iw.dao.ResidenteDAO;
import co.udea.iw.dto.Residente;
import co.udea.iw.exception.IWDaoException;

public class ResidenteDAOHibernate extends HibernateDaoSupport implements ResidenteDAO {

	@Override
	public Residente insertar(Residente residente) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Residente modificar(Residente residente) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Residente residente) throws IWDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Residente> obtener() throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Residente obtener(String cedula) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
