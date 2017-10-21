package co.udea.iw.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.udea.iw.dao.UsuarioDAO;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario modificar(Usuario usuario) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Usuario usuario) throws IWDaoException {
		// TODO Auto-generated method stub

	}
}
