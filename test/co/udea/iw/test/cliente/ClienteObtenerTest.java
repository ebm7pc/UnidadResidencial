package co.udea.iw.test.cliente;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.udea.iw.dao.ClienteDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class ClienteObtenerTest {

	@Autowired
	ClienteDAO clienteDAO;
	
	@Test
	@Rollback(false)
	public void testObtener() {
		Cliente cliente = null;
		try {
			cliente = clienteDAO.obtener(123);
			System.out.println("Nombre cliente: " + cliente.getNombre());
			System.out.println("Apartamento del cliente: " + cliente.getApartamento());
			assertTrue(true);
		}catch (IWDaoException e) {
			fail(e.getMessage());
		}
	}
}
