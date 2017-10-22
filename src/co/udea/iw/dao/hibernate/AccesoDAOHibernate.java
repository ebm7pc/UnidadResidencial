package co.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.udea.iw.dao.AccesoDAO;
import co.udea.iw.dto.Acceso;
import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;
/**
 * 
 * @author Eduardo B , Yesid M
 * Clase que implementa los metodos de la logica del negocio para la tabla de accesos
 */
public class AccesoDAOHibernate extends HibernateDaoSupport implements AccesoDAO {

	
	/**
	 * Metodo que permite insertar a la base de datos un nuevo acceso
	 */
	@Override
	public Acceso insertar(Acceso acceso) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			tx = session.beginTransaction();
			session.save(acceso);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return acceso;
	}
	
	/**
	 * Metodo que permite obtener todos los acccesos registrados en la base de datos 
	 */
	@Override
	public List<Acceso> obtener() throws IWDaoException {
		List<Acceso> accesos = new ArrayList<Acceso>();
		try {
			Session session = this.getSessionFactory().getCurrentSession(); // getSession();
			Criteria criteria = session.createCriteria(Acceso.class);
			accesos = criteria.list();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}
		return accesos;
	}

	/**
	 * Metodo que permite obtener todos los accesos realizados por un cliente, recive como paramero el ficho del cliente 
	 */
	@Override
	public List<Acceso> obtenerByIdCliente(Integer ficho) throws IWDaoException {
		List<Acceso> accesos = new ArrayList<>();
		List<Acceso> accesosFiltrados = new ArrayList<>();
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			Criteria criteria = session.createCriteria(Acceso.class);
			accesos = criteria.list();
			for(Acceso acceso : accesos) {
				if (ficho.equals(acceso.getIdCliente().getFicho())) {
					accesosFiltrados.add(acceso);
				}
			}
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return accesosFiltrados;
	}

	/**
	 * Metodo que permite obtener los acesos que se realizaron entre un par de fechas dadas, las cuales son recividas como parametros
	 */
	@Override
	public List<Acceso> obtenerByFecha(Date fechaInicial, Date fechaFinal) throws IWDaoException {
		List<Acceso> accesos = new ArrayList<>();
		List<Acceso> accesosFiltrados = new ArrayList<>();
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			Criteria criteria = session.createCriteria(Acceso.class);
			accesos = criteria.list();
			for(Acceso acceso : accesos) {
				if (fechaInicial.before(acceso.getFechaAcceso()) && acceso.getFechaAcceso().before(fechaFinal)) {
					accesosFiltrados.add(acceso);
				}
			}
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return accesosFiltrados;
	}
	
	/**
	 * Metodo que retorna una lista de accesos de la base de datos por tipo de cliente ya sea Residente o Visistante 
	 */

	@Override
	public List<Acceso> obtenerByTipoCliente(String tipo) throws IWDaoException {
		List<Acceso> accesos = new ArrayList<>();
		List<Acceso> accesosFiltrados = new ArrayList<>();
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			Criteria criteria = session.createCriteria(Acceso.class);
			accesos = criteria.list();
			for(Acceso acceso : accesos) {
				if (tipo.equalsIgnoreCase(acceso.getIdCliente().getTipo())) {
					accesosFiltrados.add(acceso);
				}
			}
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return accesosFiltrados;
	}

}
