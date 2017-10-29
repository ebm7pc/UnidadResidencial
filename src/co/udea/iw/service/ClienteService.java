package co.udea.iw.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.udea.iw.dao.ClienteDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;
import co.udea.iw.exception.IWServiceException;
import co.udea.iw.util.validations.Validaciones;

public class ClienteService {

	@Autowired
	private ClienteDAO clienteDAO;
	
	
	public void guardarCliente(Integer ficho, String tipo , String nombre, String apellido, Long identificacion, String apartamento
			,Long telefono,Long celular,String correo,boolean tiene_vehiculo,String responsable, Date fecha_salida) throws  IWDaoException, IWServiceException{
		
		Cliente cliente=null; 
		
		if(Validaciones.isTextoVacio(String.valueOf(ficho))) {
			throw new IWServiceException("El ficho no puede ser nulo ni vacio ");
		}
		
		if(Validaciones.isTextoVacio(tipo)) {
			throw new IWServiceException("El tipo de usuario debe estar definido ");
		}
		
		if(Validaciones.isTextoVacio(nombre)) {
			throw new IWServiceException("El nombre de usuario no puede ser vacio ");
		}
		
		if(Validaciones.isTextoVacio(apellido)) {
			throw new IWServiceException("El apellido del cliente no puede estar vacio ");
		}
		
		if(Validaciones.isTextoVacio(String.valueOf(identificacion))) {
			throw new IWServiceException("La identificacion del usuarion no puede estar vacia ");
		}		
		
		if(Validaciones.isTextoVacio(String.valueOf(apartamento))) {
			throw new IWServiceException("La identificacion del usuarion no puede estar vacia ");
		}	
		
		if(Validaciones.isTextoVacio(String.valueOf(String.valueOf(tiene_vehiculo)))) {
			throw new IWServiceException("La identificacion del usuarion no puede estar vacia ");
		}
		
				
		if(!Validaciones.isTextoVacio(correo)) {
		if(!Validaciones.isEmail(correo)) {
			throw new IWServiceException("El correo electronico del cliente debe ser valido");
		}}
		
		cliente= new Cliente();
		
		cliente.setFicho(ficho);;
		cliente.setTipo(tipo);
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setIdentificacion(identificacion);
		cliente.setApartamento(apartamento);
		cliente.setTelefono(telefono);
		cliente.setCelular(celular);
		cliente.setTieneVehiculo(tiene_vehiculo);
		cliente.setResponsable(responsable);
		cliente.setFechaSalida(fecha_salida);
		cliente.setFechaRegistro(new Date());
		
		
		clienteDAO.insertar(cliente);
	}
	
	public List<Cliente> obtener()throws IWDaoException{
		return clienteDAO.obtener();
		
	}
	
	public Cliente obtener(Integer ficho) throws IWDaoException, IWServiceException{
		
		if(ficho == null) {
			
			throw new IWServiceException("El ficho del cliente no puede esatr vacio");
		}
		
		return clienteDAO.obtener(ficho);
		
	}
}
