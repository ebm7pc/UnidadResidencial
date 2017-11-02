package co.udea.iw.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.udea.iw.dao.AccesoDAO;
import co.udea.iw.dto.Acceso;
import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;
import co.udea.iw.exception.IWServiceException;
import co.udea.iw.util.validations.Validaciones;

public class AcccesoService {

	@Autowired
	AccesoDAO accesoDAO;
	
	public void guardarAcceso(Integer id, Cliente clienteAccede) throws  IWDaoException, IWServiceException{
		
		Acceso acceso =null; 
		
		if(Validaciones.isTextoVacio(String.valueOf(id))) {
			throw new IWServiceException("El id no puede ser vacío");
		}
		
		if(clienteAccede==null) {
			throw new IWServiceException("El tipo de usuario debe estar definido ");
		}
		
		acceso= new Acceso();
		
		acceso.setId(id);
		acceso.setIdCliente(clienteAccede);
		acceso.setFechaAcceso(new Date());
		accesoDAO.insertar(acceso);
	}
	
	public List<Acceso> obtener()throws IWDaoException, IWServiceException{
		return accesoDAO.obtener();
	}
	
	public List<Acceso> obtenerPorTipoC(String tipo)throws IWDaoException, IWServiceException{
		if(Validaciones.isTextoVacio(tipo)){
			throw new IWServiceException("El tipo de cliente no puede ser vacío");
		}
		return accesoDAO.obtenerByTipoCliente(tipo);
	}
	
	public List<Acceso> obtenerPorCliente(Integer ficho)throws IWDaoException, IWServiceException{
		if(Validaciones.isTextoVacio(String.valueOf(ficho))){
			throw new IWServiceException("El ficho de cliente no puede ser vacío");
		}
		return accesoDAO.obtenerByIdCliente(ficho);
	}
	
	public List<Acceso> obtenerPorFecha(Date fechaInicio, Date fechaFinal)throws IWDaoException, IWServiceException{
		if(fechaInicio==null || fechaFinal==null){
			throw new IWServiceException("Las fechas no pueden ser vacías");
		}
		return accesoDAO.obtenerByFecha(fechaInicio, fechaFinal);
	}
	
}
