package co.udea.iw.dao;

import co.udea.iw.dto.Usuario;
import co.udea.iw.exception.IWDaoException;

public interface UsuarioDAO {
	public Usuario obtener(String login) throws IWDaoException;
	

}
