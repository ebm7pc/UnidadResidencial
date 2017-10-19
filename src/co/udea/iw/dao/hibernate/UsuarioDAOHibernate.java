package co.udea.iw.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.udea.iw.dao.UsuarioDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.dto.Usuario;
import co.udea.iw.exception.IWDaoException;

public class UsuarioDAOHibernate extends HibernateDaoSupport implements UsuarioDAO {

	@Override
	public Usuario obtener(String login) throws IWDaoException {
		Session session = null;
		Usuario usuario = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			usuario = (Usuario)session.load(Usuario.class, login);
		}catch(HibernateException e) {
			throw new IWDaoException(e);
		}finally {
			session.close();
		}
		return usuario;
	}
}
