package co.udea.iw.dao.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class AccesoDAOHibernate extends HibernateDaoSupport implements AccesoDAO {

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
	
	
	
	private Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
	
	

	@Override
	public List<Acceso> obtenerByFecha(Date fechaInicial, Date fechaFinal) throws IWDaoException {
		//Date fechaI=ParseFecha(fechaInicial); Date fechaF=ParseFecha(fechaFinal);
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
