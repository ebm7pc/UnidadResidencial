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
/**
 * 
 * @author Eduardo B , Yesid M
 * Clase que implementa los metodos de la logica del negocio para la tabla de vehiculos
 */
public class VehiculoDAOHibernate extends HibernateDaoSupport implements VehiculoDAO {

	
	/**
	 * Metodo que permite insertar un nuevo vehiculo a la base de datos
	 */
	@Override
	public Vehiculo insertar(Vehiculo vehiculo) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
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

	/**
	 * Metodo que permite eliminar un vehiculo de la base de datos
	 */
	@Override
	public void eliminar(Vehiculo vehiculo) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session =  getSession();
			tx = session.beginTransaction();
			session.delete(vehiculo);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
	}

	/**
	 * Metodo que retor una lista de Vehiculos pertenesientes a un cliente 
	 */
	@Override
	public List<Vehiculo> obtenerByCliente(Integer idCliente) throws IWDaoException {
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		List<Vehiculo> vehiculosFiltrados = new ArrayList<Vehiculo>();
		Session session = null;
		try {
			session = getSession();
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

	/**
	 * Metodo que permite obtener el cliente al cual pertenece un vehiculo con una placa dada
	 */
	@Override
	public Cliente obtenerById(String placa) throws IWDaoException {
		Vehiculo vehiculo = null;
		Cliente cliente = null;
		Session session = null;
		try {
			session =  getSession();
			vehiculo = (Vehiculo) session.load(Vehiculo.class, placa);
			cliente=vehiculo.getIdCliente();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return cliente;		
	}
	
	
	/**
	 * Metodo que permite obtenerun vehiculo con una placa dada
	 */
	@Override
	public Vehiculo obtener(String placa) throws IWDaoException {
		Vehiculo vehiculo = null;
		Cliente cliente = null;
		Session session = null;
		try {
			session =  getSession();
			vehiculo = (Vehiculo) session.load(Vehiculo.class, placa);			
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return vehiculo;		
	}

}
