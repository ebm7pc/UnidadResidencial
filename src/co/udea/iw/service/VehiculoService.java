package co.udea.iw.service;

import java.util.List;

import co.udea.iw.dao.VehiculoDAO;
import co.udea.iw.dto.Cliente;
import co.udea.iw.dto.Vehiculo;
import co.udea.iw.exception.IWDaoException;
import co.udea.iw.exception.IWServiceException;
import co.udea.iw.util.validations.Validaciones;

public class VehiculoService {
	@Autowired
	VehiculoDAO vehiculoDAO;
	
	public void guardarUsuario(String placa, String marca, Cliente cliente) throws  IWDaoException, IWServiceException{
		
		Vehiculo vehiculo =null; 
		
		if(Validaciones.isTextoVacio(placa)) {
			throw new IWServiceException("La placa del vehiculo no puede ser vacía");
		}
		
		if(Validaciones.isTextoVacio(marca)) {
			throw new IWServiceException("La marca del vehiculo no puede ser vacía");
		}
		
		if(cliente == null ) {
			throw new IWServiceException("El vehiculo debe tener un propietario");
		}  
		
		vehiculo= new Vehiculo();
		
		vehiculo.setPlaca(placa);
		vehiculo.setMarca(marca);
		vehiculo.setIdCliente(cliente);
		vehiculoDAO.insertar(vehiculo);
	}
	
	public void eliminarUsuario(String placa) throws IWDaoException, IWServiceException {
		Vehiculo vehiculo =null;
		if(Validaciones.isTextoVacio(placa)){
			throw new IWServiceException("La placa del vehiculo no puede ser vacío");
		}
		vehiculo=vehiculoDAO.obtener(placa);
		if(vehiculo==null) {
			throw new IWServiceException("No existe un vehiculo con esta placa");
		}
		vehiculoDAO.eliminar(vehiculo);
	}
	
	public Cliente obtenerDueño(String placa) throws IWDaoException, IWServiceException {
		
		if(Validaciones.isTextoVacio(placa)){
			throw new IWServiceException("La placa del vehiculo no puede ser vacío");
		}
		
		return vehiculoDAO.obtenerById(placa);
	}
	
public List<Vehiculo> obtenerVehiculos(Integer idCliente) throws IWDaoException, IWServiceException {
		
		if(Validaciones.isTextoVacio(String.valueOf(idCliente))){
			throw new IWServiceException("La identificacion del cliente no puede ser vacía");
		}
		
		return vehiculoDAO.obtenerByCliente(idCliente);
	}
	
}
