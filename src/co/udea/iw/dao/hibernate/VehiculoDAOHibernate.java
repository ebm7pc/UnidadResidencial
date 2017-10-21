package co.udea.iw.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.udea.iw.dao.VehiculoDAO;
import co.udea.iw.dto.Vehiculo;
import co.udea.iw.exception.IWDaoException;

public class VehiculoDAOHibernate extends HibernateDaoSupport implements VehiculoDAO {

	@Override
	public Vehiculo insertar(Vehiculo vehiculo) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Vehiculo vehiculo) throws IWDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vehiculo> obtener(Integer idCliente) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehiculo obtenerById(Integer id) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
