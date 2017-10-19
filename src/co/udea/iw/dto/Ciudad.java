package co.udea.iw.dto;

/**
 * Clase dto para los datos de las ciudades
 * @author Eduardo Bedoya Marín
 *
 */
public class Ciudad {
	
	/**
	 * Código de la ciudad
	 */
	private Integer codigo;
	/**
	 * Nombre completo de la ciudad
	 */
	private String nombre;
	/**
	 * Código del área en la que está ubicada la ciudad
	 */
	private String codigoArea;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}

}
