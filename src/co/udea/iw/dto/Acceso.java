package co.udea.iw.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

/**
 * Clasedto para los datos de Acceso
 * @author Eduardo B , Yesid M
 *
 */
//@Entity
//@Table(name = "accesos")
@XmlRootElement
public class Acceso implements Serializable {
	
//	@SequenceGenerator(name = "native", sequenceName = "AUTO_INCREMENT")
//	@GeneratedValue(strategy=GenerationType.IDENTITY, generator = "native")
//	@GenericGenerator(name = "native", strategy = "native")
	
	
//	@Id
//	@Column(name="id", unique = true, nullable = false)
//	@GeneratedValue(strategy= GenerationType.IDENTITY, generator="MySequenceGenerator")
//	@SequenceGenerator(allocationSize=1, schema="AUTO_INCREMENT",  name="MySequenceGenerator", sequenceName = "AUTO_INCREMENT")
	
	/**
	 * Identificador único del acceso
	 */
//	@Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	
	/**
	 * Fecha en que se realizó el acceso
	 */
	private Date fechaAcceso;
	
	/**
	 * Cliente (Residente o Visitante) que realizó el acceso
	 */
	private Cliente idCliente;
	
	/**
	 * Constructor de la clase acceso
	 * @param fechaA Fecha de acceso
	 * @param cliente Cliente que accedió
	 */
	public Acceso(Date fechaA, Cliente cliente) {
		super();
		this.fechaAcceso = fechaA;
		this.idCliente = cliente;
	}
	
	public Acceso() {
		super();
	}
	

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
