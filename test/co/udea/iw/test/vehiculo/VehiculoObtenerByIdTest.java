package co.udea.iw.test.vehiculo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.udea.iw.dao.VehiculoDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class VehiculoObtenerByIdTest {

	@Autowired
	VehiculoDAO vehiculoDao;
	Cliente cliente;
	
	@Test
	public void testObtenerById() {
		try {
			cliente = vehiculoDao.obtenerById("gdy43c");
				System.out.println("usuario:: " + cliente.getNombre() + " " + cliente.getApellido() + " " + cliente.getApartamento());
			assertTrue(true);
		}catch(IWDaoException e) {
			fail(e.getMessage());
		}
		
	}

}
