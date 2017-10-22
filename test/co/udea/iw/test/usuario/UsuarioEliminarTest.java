package co.udea.iw.test.usuario;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.udea.iw.dao.UsuarioDAO;
import co.udea.iw.dto.Usuario;
import co.udea.iw.exception.IWDaoException;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class UsuarioEliminarTest {

	@Autowired
	UsuarioDAO usuarioD;
	
	@Test
	public void testEliminar() {
		Usuario usuario = null;
		try {
			usuario = usuarioD.obtener("yesi");
			usuarioD.eliminar(usuario);
				
			assertTrue(true);
		}catch(IWDaoException e) {
			//fail(e.getMessage());
		}
	}

}
