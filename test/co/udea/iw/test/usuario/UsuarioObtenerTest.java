package co.udea.iw.test.usuario;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.udea.iw.dao.UsuarioDAO;
import co.udea.iw.dto.Usuario;
import co.udea.iw.exception.IWDaoException;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class UsuarioObtenerTest {
	
	@Autowired
	UsuarioDAO usuarioD;

	@Test
	@Rollback(false)
	public void testObtener() {
		
		Usuario usuario = null;
		try {
			usuario = usuarioD.obtener("yesi");
				System.out.println("usuario:: " + usuario.getNombreUsuario() + " " + usuario.getPassword() + " " + usuario.getTipoUsuario());
			assertTrue(true);
		}catch(IWDaoException e) {
			fail(e.getMessage());
		}
		
		
	}


}
