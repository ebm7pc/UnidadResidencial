package co.udea.iw.dto;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author Eduardo B , Yesid M
 * Clase dto para la tabla clientes de la base de datos
 */
@XmlRootElement
public class Cliente implements Serializable {
	/**
	 * Ficho con el que se validara el acceso del cliente
	 */
	private Integer ficho;
	/**
	 * Tipo del cliente, ya sea Residente o Visitante
	 */
	private String tipo;
	/**
	 * Nombre del cliente
	 */
	private String nombre;
	/**
	 * Apellido del cliente
	 */
	private String apellido;
	/**
	 * Cedula del cliente 
	 */
	private Long identificacion;
	/**
	 * identificacion del apartamente al que pertenece el cliente
	 */
	private String apartamento;
	/**
	 * Numero telefonico del cliente
	 */
	private Long telefono;
	/**
	 * Numero del celular del cliente
	 */
	private Long celular;
	/**
	 * Correo electronico del cliente
	 */
	private String correo;
	
	/**
	 * Valor booleano que permite determinar si el Cliente visitante o Residente se registro con vehiculo o sin vehiculo
	 * 0 es sin vehiculo, 1 es con veh�culo
	 * Los clientes Residentes pueden registrar mas de un veh�culo
	 */
	private boolean tieneVehiculo;
	
	/**
	 * Fecha en la que se registr� el cliente Residente o Visitante
	 */
	private Date fechaRegistro;
	
	/**
	 * Nombre de la persona hacia la cual se dirige el Visitante
	 */
	private String responsable;
	
	/**
	 * Fecha limite a la que tiene permiso de acceso un Cliente de tipo Visitante
	 */
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
