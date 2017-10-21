package co.udea.iw.test.cliente;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
public class ClienteObtenerByTipoTest {

	@Autowired
	ClienteDAO clienteDao;

	
	@Test
	@Rollback(false)
	public void testObtener() {
		// fail("Not yet implemented");
		List<Cliente> clientes = null;
		System.out.println("llega 1");
		try {
			System.out.println("llega 2");
			clientes = clienteDao.obtener();
			System.out.println("llega 3");
			for (Cliente cliente : clientes) {
				System.out.println("Nombre cliente: " + cliente.getNombre());
			}
			assertTrue(false);
		} catch (IWDaoException e) {
			 fail(e.getMessage());
		}
	}

	// @Test
	// @Rollback(false)
	// public void testObtenerByTipo() {
	// //fail("Not yet implemented");
	// List<Cliente> clientes = null;
	// try {
	// clientes = clienteDao.obtenerByTipo("11");
	// for(Cliente cliente : clientes) {
	// System.out.println("Nombre cliente: " + cliente.getNombre());
	// System.out.println("Apartamento del cliente: " + cliente.getApartamento());
	// }
	// assertTrue(true);
	// }catch(IWDaoException e) {
	// //fail(e.getMessage());
	// }

	
	
	
	
	// @Test
		// @Rollback(false)
		// public void testObtener() {
		//
		// Cliente cliente = null;
		// try {
		// cliente = clienteDao.obtener(11);
		// System.out.println("usuario:: " + cliente.getNombre());
		// assertTrue(true);
		// } catch (IWDaoException e) {
		// // fail(e.getMessage());
		// }
		//
		// }
	
	
	
}
