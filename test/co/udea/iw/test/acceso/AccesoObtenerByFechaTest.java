package co.udea.iw.test.acceso;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import co.udea.iw.dao.AccesoDAO;
import co.udea.iw.dto.Acceso;
import co.udea.iw.exception.IWDaoException;

public class AccesoObtenerByFechaTest {

	@Autowired
	AccesoDAO accesoDAO;
	
	@Test
	@Rollback(false)
	public void testObtenerByFecha() {
		List<Acceso> accesos = null;
		Date fechaI = new Date("2017/10/01 20:15:05");
		Date fechaF = new Date("2017/10/22 10:00:00");
		try {
			accesos = accesoDAO.obtenerByFecha(fechaI, fechaF);
			for(Acceso acceso : accesos) {
				System.out.println();
			}
			assertTrue(true);
		}catch (IWDaoException e) {
			fail(e.getMessage());
		}
	}

}
