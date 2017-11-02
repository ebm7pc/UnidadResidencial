package co.udea.iw.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.udea.iw.dao.AccesoDAO;
import co.udea.iw.dao.ClienteDAO;
import co.udea.iw.dto.Acceso;
import co.udea.iw.dto.Cliente;
import co.udea.iw.exception.IWDaoException;
import co.udea.iw.exception.IWServiceException;
import co.udea.iw.util.validations.Validaciones;

public class AccesoService {

	@Autowired
	AccesoDAO accesoDAO;
	ClienteDAO clienteDAO;
	
	public AccesoDAO getAccesoDAO() {
		return accesoDAO;
	}

	public void setAccesoDAO(AccesoDAO accesoDAO) {
		this.accesoDAO = accesoDAO;
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}


	public void guardarAcceso(Integer id, Integer clienteAccede) throws  IWDaoException, IWServiceException{
		
		Acceso acceso =null;
		Cliente cliente=null;
		
		if(Validaciones.isTextoVacio(String.valueOf(id))) {
			throw new IWServiceException("El id no puede ser vacío");
		}
		cliente=clienteDAO.obtener(clienteAccede);
		if(cliente==null) {
			throw new IWServiceException("El usuario no existe");
		}
		
		acceso= new Acceso();
		
		acceso.setId(id);
		acceso.setIdCliente(cliente);
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
