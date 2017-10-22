package co.udea.iw.test.vehiculo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.udea.iw.dao.VehiculoDAO;
import co.udea.iw.dto.Vehiculo;
import co.udea.iw.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class VehiculoObtenerByClienteTest {

	@Autowired
	VehiculoDAO vehiculoDao;
	
	@Test
	public void testObtenerByCliente() {
		List<Vehiculo> vehiculos=null;
		
		try {
			vehiculos=vehiculoDao.obtenerByCliente(12);
			
			for(Vehiculo vehiculo: vehiculos) {
				
				System.out.println("la pLaca del vehiculo es:" + vehiculo.getPlaca() + " la marca del vehiculo es:"+ vehiculo.getMarca());
			}
			
			
		}catch(IWDaoException e) {
			fail(e.getMessage());
		}
	}

}
