package co.udea.iw.test.acceso;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.udea.iw.dao.AccesoDAO;
import co.udea.iw.dto.Acceso;
import co.udea.iw.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class AccesoObtenerListaTest {

	@Autowired
	AccesoDAO accesoDAO;
	
	@Test
	@Rollback(false)
	public void testObtener() {
		List<Acceso> accesos = null;
		try {
			accesos = accesoDAO.obtener();
			for(Acceso acceso : accesos) {
				System.out.println("Quién Accedió: " + acceso.getIdCliente().getNombre() + " " + acceso.getIdCliente().getApellido() + ". Fecha de acceso: " + acceso.getFechaAcceso());
			}
			assertTrue(true);
		}catch (IWDaoException e) {
			fail(e.getMessage());
		}
	}

}
