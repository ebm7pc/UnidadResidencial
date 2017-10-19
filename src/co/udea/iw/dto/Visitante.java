package co.udea.iw.dto;

import java.io.Serializable;
import java.util.Date;

public class Visitante implements Serializable {
	private Integer ficho;
	private String tipo;
	private String nombre;
	private String apellido;
	private Integer identificacion;
	private String apartamento;
	private boolean tieneVehiculo;
	private Date fechaRegistro;
	private String responsable;
	private Date fechaSalida;
	
	public Integer getFicho() {
		return ficho;
	}
	public void setFicho(Integer ficho) {
		this.ficho = ficho;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}
	public String getApartamento() {
		return apartamento;
	}
	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}
	public boolean isTieneVehiculo() {
		return tieneVehiculo;
	}
	public void setTieneVehiculo(boolean tieneVehiculo) {
		this.tieneVehiculo = tieneVehiculo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	
}
