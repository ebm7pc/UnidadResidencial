package co.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.udea.iw.dao.VehiculoDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.dto.Vehiculo;
import co.udea.iw.exception.IWDaoException;

public class VehiculoDAOHibernate extends HibernateDaoSupport implements VehiculoDAO {

	@Override
	public Vehiculo insertar(Vehiculo vehiculo) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			tx = session.beginTransaction();
			session.save(vehiculo);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return vehiculo;
	}

	@Override
	public void eliminar(Vehiculo vehiculo) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			tx = session.beginTransaction();
			session.delete(vehiculo);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Vehiculo> obtenerByCliente(Integer idCliente) throws IWDaoException {
		List<Vehiculo> vehiculos = new ArrayList<>();
		List<Vehiculo> vehiculosFiltrados = new ArrayList<>();
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			Criteria criteria = session.createCriteria(Vehiculo.class);
			vehiculos = criteria.list();
			for(Vehiculo vehiculo : vehiculos) {
				if (idCliente.equals(vehiculo.getIdCliente().getFicho())) {
					vehiculosFiltrados.add(vehiculo);
				}
			}
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return vehiculosFiltrados;
	}

	@Override
	public Cliente obtenerById(Integer placa) throws IWDaoException {
		Vehiculo vehiculo = null;
		Cliente cliente = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			vehiculo = (Vehiculo) session.load(Vehiculo.class, placa);
			cliente=vehiculo.getIdCliente();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return cliente;		
	}

}
