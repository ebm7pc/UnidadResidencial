package co.udea.iw.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author Eduardo B , Yesid M
 * Clase dto para la tabla usuarios de la base de datos
 */
@XmlRootElement
public class Usuario implements Serializable {
	/**
	 * nombre de un usuario con el que hara el loguin
	 */
	private String nombreUsuario;
	/**
	 * Contraseña del usuario
	 */
	private String password;
	/**
	 * Tipo del usuario para otorgar permisos
	 */
	private String tipoUsuario;
			
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
