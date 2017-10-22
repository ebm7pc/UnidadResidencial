package co.udea.iw.test.usuario;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.udea.iw.exception.IWDaoException;

import co.udea.iw.dao.UsuarioDAO;
import co.udea.iw.dto.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuracion.xml")
public class UsuarioInsertarTest {
    
	@Autowired
	UsuarioDAO usuarioDao;
	Usuario usuario;
	
	@Test
	public void testInsertar() {
		try {
			usuario=new Usuario();
			usuario.setNombreUsuario("yesi");
			usuario.setPassword("kabebe");
			usuario.setTipoUsuario("Regular");
			usuarioDao.insertar(usuario);
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

}
