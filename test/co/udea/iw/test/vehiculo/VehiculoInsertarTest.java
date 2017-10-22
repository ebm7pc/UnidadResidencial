package co.udea.iw.test.vehiculo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.udea.iw.dao.ClienteDAO;
import co.udea.iw.dao.VehiculoDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.dto.Usuario;
import co.udea.iw.dto.Vehiculo;
import co.udea.iw.exception.IWDaoException;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuracion.xml")
public class VehiculoInsertarTest {

	@Autowired
	VehiculoDAO vehiculoDao;
	Vehiculo vehiculo;
	@Autowired
	ClienteDAO clienteDao;
	Cliente cliente;
	
	@Test
	public void testInsertar() {
		try {
			cliente=clienteDao.obtener(11);
			vehiculo=new Vehiculo();
			vehiculo.setPlaca("yyu49c");
			vehiculo.setMarca("Yamaha");
			vehiculo.setIdCliente(cliente);
			vehiculoDao.insertar(vehiculo);
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}

}
