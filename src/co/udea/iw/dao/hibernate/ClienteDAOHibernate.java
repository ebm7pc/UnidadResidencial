package co.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.udea.iw.dao.ClienteDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;
/**
 * 
 * @author Eduardo B , Yesid M
 * Clase que implementa los metodos de la logica del negocio para la tabla de clientes
 */
public class ClienteDAOHibernate extends HibernateDaoSupport implements ClienteDAO {

	/**
	 * Metodo que permite insertar un cliente nuevo a la base de datos
	 */
	@Override
	public Cliente insertar(Cliente cliente) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			tx = session.beginTransaction();
			session.save(cliente);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return cliente;
	}
	
	
     /**
      * Metodo que permite modificar un cliente ya registrado en la base de datos 
      */
	@Override
	public Cliente modificar(Cliente cliente) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			tx = session.beginTransaction();
			session.update(cliente);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return cliente;
	}

	/**
	 * Metodo que permite eliminar un Cliente de la base de datos 
	 */
	@Override
	public void eliminar(Cliente cliente) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			tx = session.beginTransaction();
			session.delete(cliente);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
	}
	
	

	/**
	 * Metodo que retorna una lista de clientes con todos los clientes regstrados en la base de datos 
	 */
	@Override
	public List<Cliente> obtener() throws IWDaoException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Session session = this.getSessionFactory().getCurrentSession(); // getSession();
			Criteria criteria = session.createCriteria(Cliente.class);
			clientes = criteria.list();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}
		return clientes;
	}
	
	
	/**
	 * Metodo que retorna una lista de clientes por tipo de clinete registrado en la base de datos, el tipo el el parametro de entrada del metodo 
	 */
	@Override
	public List<Cliente> obtenerByTipo(String tipo) throws IWDaoException {
		List<Cliente> clientes = new ArrayList<>();
		List<Cliente> clientesFiltrados = new ArrayList<>();
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			Criteria criteria = session.createCriteria(Cliente.class);
			clientes = criteria.list();
			for(Cliente cliente : clientes) {
				if (tipo.equalsIgnoreCase(cliente.getTipo())) {
					clientesFiltrados.add(cliente);
				}
			}
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return clientesFiltrados;
	}
	

	/**
	 * Metodo que permite obtener un cliente con el numero de ficho del cliente
	 */
	@Override
	public Cliente obtener(Integer ficho) throws IWDaoException {
		Cliente cliente = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			cliente = (Cliente) session.load(Cliente.class, ficho);
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return cliente;
	}

}
