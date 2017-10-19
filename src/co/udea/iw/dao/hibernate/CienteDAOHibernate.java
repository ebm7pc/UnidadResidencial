package co.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.udea.iw.dao.ClienteDAO;
import co.udea.iw.dto.Ciudad;
import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;

public class CienteDAOHibernate extends HibernateDaoSupport implements ClienteDAO {

	@Override
	public Cliente insertar(Cliente cliente) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
		session = this.getSessionFactory().getCurrentSession(); //getSession();
		tx = session.beginTransaction();
		session.save(cliente);
		tx.commit();
		}catch (HibernateException e) {
			throw new IWDaoException(e);			
		}finally {
			session.close();
		}
		return cliente;
	}

	@Override
	public Cliente modificar(Cliente cliente) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
		session = this.getSessionFactory().getCurrentSession(); // getSession();
		tx = session.beginTransaction();
		session.update(cliente);
		tx.commit();
		}catch (HibernateException e) {
			throw new IWDaoException(e);			
		}finally {
			session.close();
		}
		return cliente;
	}

	@Override
	public void eliminar(Cliente cliente) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
		session = this.getSessionFactory().getCurrentSession(); //getSession();
		tx = session.beginTransaction();
		cliente.setEliminado(true);
		cliente.setFechaEliminacion(new Date());
		session.delete(cliente);
		tx.commit();
		}catch (HibernateException e) {
			throw new IWDaoException(e);			
		}finally {
			session.close();
		}
	}

	@Override
	public List<Cliente> obtener() throws IWDaoException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
		Session session = this.getSessionFactory().getCurrentSession(); //getSession();
		Criteria criteria = session.createCriteria(Cliente.class);
		clientes = criteria.list();
		}catch (HibernateException e) {
			throw new IWDaoException(e);
		}
		return clientes;
	}

	@Override
	public Cliente obtener(String cedula) throws IWDaoException {
		Cliente cliente = null;
		Session session = null;
		try {
		session = this.getSessionFactory().getCurrentSession(); //getSession();
		cliente = (Cliente)session.load(Cliente.class, cedula);
		}catch (HibernateException e) {
			throw new IWDaoException(e);			
		}finally {
			session.close();
		}
		return cliente;
	}

}
