package co.udea.iw.dto;

import java.io.Serializable;
import java.util.Date;

public class Acceso implements Serializable {
	private Integer id;
	private Date fechaAcceso;
	private Cliente idCliente;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFechaAcceso() {
		return fechaAcceso;
	}
	public void setFechaAcceso(Date fechaAcceso) {
		this.fechaAcceso = fechaAcceso;
	}
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	

}
