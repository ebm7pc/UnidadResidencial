package co.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.udea.iw.dao.VisitanteDAO;
import co.udea.iw.dto.Visitante;
import co.udea.iw.exception.IWDaoException;

public class VisitanteDAOHibernate extends HibernateDaoSupport implements VisitanteDAO {

	@Override
	public Visitante insertar(Visitante visitante) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
		session = this.getSessionFactory().getCurrentSession(); //getSession();
		tx = session.beginTransaction();
		session.save(visitante);
		tx.commit();
		}catch (HibernateException e) {
			throw new IWDaoException(e);			
		}finally {
			session.close();
		}
		return visitante;
	}

	@Override
	public Visitante modificar(Visitante visitante) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
		session = this.getSessionFactory().getCurrentSession(); // getSession();
		tx = session.beginTransaction();
		session.update(visitante);
		tx.commit();
		}catch (HibernateException e) {
			throw new IWDaoException(e);			
		}finally {
			session.close();
		}
		return visitante;
	}

	@Override
	public void eliminar(Visitante visitante) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
		session = this.getSessionFactory().getCurrentSession(); //getSession();
		tx = session.beginTransaction();
		session.delete(visitante);
		tx.commit();
		}catch (HibernateException e) {
			throw new IWDaoException(e);			
		}finally {
			session.close();
		}
	}

	@Override
	public List<Visitante> obtener() throws IWDaoException {
		List<Visitante> visitantes = new ArrayList<Visitante>();
		try {
		Session session = this.getSessionFactory().getCurrentSession(); //getSession();
		Criteria criteria = session.createCriteria(Visitante.class);
		visitantes = criteria.list();
		}catch (HibernateException e) {
			throw new IWDaoException(e);
		}
		return visitantes;
	}

	@Override
	public Visitante obtener(String cedula) throws IWDaoException {
		Visitante visitante = null;
		Session session = null;
		try {
		session = this.getSessionFactory().getCurrentSession(); //getSession();
		visitante = (Visitante)session.load(Visitante.class, cedula);
		}catch (HibernateException e) {
			throw new IWDaoException(e);			
		}finally {
			session.close();
		}
		return visitante;
	}

}
