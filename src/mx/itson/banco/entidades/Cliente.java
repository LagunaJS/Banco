/**
 * 
 */
package mx.itson.banco.entidades;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author LagunaJS
 *
 */
@Entity
public class Cliente {
	private int id;
	private String nombre;
	private String correo;
	private Date fechaDeAlta;
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	@Basic
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the correo
	 */
	@Basic
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * @return the fechaDeAlta
	 */
	@Basic
	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}
	/**
	 * @param fechaDeAlta the fechaDeAlta to set
	 */
	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

}
