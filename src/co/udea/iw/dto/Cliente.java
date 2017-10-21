package co.udea.iw.dto;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable {
	private Integer ficho;
	private String tipo;
	private String nombre;
	private String apellido;
	private Long identificacion;
	private String apartamento;
	private Long telefono;
	private Long celular;
	private String correo;
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
	public Long getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}
	public String getApartamento() {
		return apartamento;
	}
	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public Long getCelular() {
		return celular;
	}
	public void setCelular(Long celular) {
		this.celular = celular;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
