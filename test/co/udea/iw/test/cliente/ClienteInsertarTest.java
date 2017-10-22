package co.udea.iw.test.cliente;

import static org.junit.Assert.*;

import java.util.Date;

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
public class ClienteInsertarTest {

	@Autowired
	ClienteDAO clienteDAO;
	
	@Test
	@Rollback(false)
	public void testInsertar() {
		Date fechaR = new Date();
		try {
			Cliente cliente = new Cliente();
			cliente.setFicho(123);
			cliente.setTipo("Visitante");
			cliente.setNombre("pepito");
			cliente.setApellido("perez");
			cliente.setIdentificacion(55667788L);
			cliente.setApartamento("casa 101");
			cliente.setTelefono(null);
			cliente.setCelular(null);
			cliente.setCorreo(null);
			cliente.setTieneVehiculo(false);
			cliente.setFechaRegistro(fechaR);
			cliente.setResponsable("doña señora");
			cliente.setFechaSalida(fechaR);
			clienteDAO.insertar(cliente);
			assertTrue(true);
		} catch (IWDaoException e) {
			fail(e.getMessage());
		}
	}

}
