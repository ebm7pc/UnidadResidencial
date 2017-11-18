package co.udea.iw.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.udea.iw.dao.UsuarioDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.dto.Usuario;
import co.udea.iw.exception.IWDaoException;
/**
 * 
 * @author Eduardo B , Yesid M
 * Clase que implementa los metodos de la logica del negocio para la tabla de usuarios
 */
public class UsuarioDAOHibernate extends HibernateDaoSupport implements UsuarioDAO {

	/**
	 * Metodo que permite obtener un usuaruio de la base de datos por el nombre de usuario
	 */
	@Override
	public Usuario obtener(String nombre) throws IWDaoException {
		Session session = null;
		Usuario usuario = null;
		try {
			session = getSession();
			usuario = (Usuario)session.load(Usuario.class, nombre);
		}catch(HibernateException e) {
			throw new IWDaoException(e);
		}finally {
			session.close();
		}
		return usuario;
	}

	/**
	 * Metodo que permite insertar un usuario a la base de datos por nombre de usuario
	 */
	@Override
	public Usuario insertar(Usuario usuario) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
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

	/**
	 * Metodo que permite modificar la contraseña de un usuario en la base de datos por medio del nombre de usuario
	 */
	@Override
	public Usuario modificar(String nombre, String pwd) throws IWDaoException {
		Usuario usuario=null;
		Transaction tx = null;
		Session session = null;
		try {
			usuario=obtener(nombre);
			session = getSession();
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

	/**
	 * Metodo que permite eliminar un usuario de la base de datos
	 */
	@Override
	public void eliminar(Usuario usuario) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			session.delete(usuario);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}
	}
	
	/**
	 * Metodo que permite validar un usuario de la base de datos por nombre de usuario y dentro de este, por contraseña
	 */
	@Override
	public String login(String nombre, String pwd) throws IWDaoException {
		Usuario usuario = null;
		Session session = null;
		String inicioSesion = "El usuario no existe";
		try {
			session = getSession();
			usuario = (Usuario) session.load(Usuario.class, nombre);
			if (usuario != null && pwd.equalsIgnoreCase(usuario.getPassword())) {
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
