package co.udea.iw.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.udea.iw.dao.UsuarioDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.dto.Usuario;
import co.udea.iw.exception.IWDaoException;

public class UsuarioDAOHibernate extends HibernateDaoSupport implements UsuarioDAO {

	@Override
	public Usuario obtener(String nombre) throws IWDaoException {
		Session session = null;
		Usuario usuario = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			usuario = (Usuario)session.load(Usuario.class, nombre);
		}catch(HibernateException e) {
			throw new IWDaoException(e);
		}finally {
			session.close();
		}
		return usuario;
	}

	@Override
	public Usuario insertar(Usuario usuario) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			tx = session.beginTransaction();
			session.save(usuario);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return usuario;
	}

	@Override
	public Usuario modificar(String nombre, String pwd) throws IWDaoException {
		Usuario usuario=null;
		Transaction tx = null;
		Session session = null;
		try {
			usuario=obtener(nombre);
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			tx = session.beginTransaction();
			usuario.setPassword(pwd);
			session.update(usuario);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return usuario;
	}

	@Override
	public void eliminar(Usuario usuario) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			tx = session.beginTransaction();
			session.delete(usuario);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public String login(String nombre, String pwd) throws IWDaoException {
		Usuario usuario = null;
		Session session = null;
		String inicioSesion = "";
		try {
			session = this.getSessionFactory().getCurrentSession(); // getSession();
			usuario = (Usuario) session.load(Cliente.class, nombre);
			if (usuario != null && usuario.getPassword()== pwd) {
				inicioSesion= usuario.getTipoUsuario();
			}
			else {
				inicioSesion="Falló el Inicio de Sesión, Compruebe sus Datos";
				System.out.println("Inicio de Sesión incorrecto");
				
			}
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
		return inicioSesion;
	}
	
}
