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
public class Ejecutivo {
	private int id;
	private String nombre;
	private String puesto;
	private Date fechaIngreso;
	private int creditosAprobados;
	private int creditosRechazados;
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
	 * @return the puesto
	 */
	@Basic
	public String getPuesto() {
		return puesto;
	}
	/**
	 * @param puesto the puesto to set
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	/**
	 * @return the fechaIngreso
	 */
	@Basic
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	/**
	 * @return the creditosAprobados
	 */
	@Basic
	public int getCreditosAprobados() {
		return creditosAprobados;
	}
	/**
	 * @param creditosAprobados the creditosAprobados to set
	 */
	public void setCreditosAprobados(int creditosAprobados) {
		this.creditosAprobados = creditosAprobados;
	}
	/**
	 * @return the creditosRechazados
	 */
	@Basic
	public int getCreditosRechazados() {
		return creditosRechazados;
	}
	/**
	 * @param creditosRechazados the creditosRechazados to set
	 */
	public void setCreditosRechazados(int creditosRechazados) {
		this.creditosRechazados = creditosRechazados;
	}

}
