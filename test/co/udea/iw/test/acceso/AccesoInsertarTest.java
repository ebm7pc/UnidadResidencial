package co.udea.iw.test.acceso;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.IdentityGenerator.GetGeneratedKeysDelegate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.udea.iw.dao.AccesoDAO;
import co.udea.iw.dao.ClienteDAO;
import co.udea.iw.dto.Acceso;
import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class AccesoInsertarTest {

	@Autowired
	AccesoDAO accesoDAO;
	
	@Autowired
	ClienteDAO clienteDAO;
	
	@Id
	@Column(name="id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator = "native")
	private Integer ident;
	
	@Test
	@Rollback(false)
	public void testInsertar() {
		try {
			Acceso acceso=null;
			Cliente cliente = clienteDAO.obtener(12);
			Date fechaAcceso = new Date();
			acceso=new Acceso(fechaAcceso,cliente);
			acceso.setId(5);
			//acceso.setId(ident);
			System.out.println(acceso.getId());
			accesoDAO.insertar(acceso);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
