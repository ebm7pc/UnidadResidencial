package co.udea.iw.dto;

/**
 * Clase dto para los datos de las ciudades
 * @author Eduardo Bedoya Mar�n
 *
 */
public class Ciudad {
	
	/**
	 * C�digo de la ciudad
	 */
	private Integer codigo;
	/**
	 * Nombre completo de la ciudad
	 */
	private String nombre;
	/**
	 * C�digo del �rea en la que est� ubicada la ciudad
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
