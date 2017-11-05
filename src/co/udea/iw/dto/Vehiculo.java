package co.udea.iw.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author Eduardo B , Yesid M
 * Clase dto para la tabla Vehiculo de la base de datos
 */
@XmlRootElement
public class Vehiculo implements Serializable {
	/**
	 * placa del vehiculo
	 */
	private String placa;
	/**
	 * marca del vehiculo
	 */
	private String marca;
	/**
	 * Cliente al cual pertence el vehiculo
	 */
	private Cliente idCliente;
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
}
