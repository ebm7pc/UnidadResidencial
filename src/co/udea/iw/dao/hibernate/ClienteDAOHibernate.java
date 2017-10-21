package co.udea.iw.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.udea.iw.dao.ClienteDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;

public class ClienteDAOHibernate extends HibernateDaoSupport implements ClienteDAO {

	@Override
	public Cliente insertar(Cliente residente) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente modificar(Cliente residente) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Cliente residente) throws IWDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> obtener() throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente obtener(String cedula) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
