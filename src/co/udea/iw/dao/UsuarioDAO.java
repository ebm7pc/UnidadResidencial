package co.udea.iw.dao;

import co.udea.iw.dto.Usuario;
import co.udea.iw.exception.IWDaoException;

public interface UsuarioDAO {
	public Usuario obtener(String nombre) throws IWDaoException;
	public Usuario insertar(Usuario usuario) throws IWDaoException;
	public Usuario modificar(String nombre, String pwd) throws IWDaoException;
	public void eliminar(Usuario usuario) throws IWDaoException;
	public String login (String nombre, String pwd) throws IWDaoException;
}
