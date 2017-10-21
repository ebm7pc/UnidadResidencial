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
		List<Cliente> clientes = null;
		try {
			clientes = clienteDAO.obtener();
			for(Cliente cliente : clientes) {
				System.out.println(cliente.getApartamento());
				System.out.println(cliente.getCelular());
			}
			assertTrue(true);
		}catch (IWDaoException e) {
			fail(e.getMessage());
		}
	}
}
